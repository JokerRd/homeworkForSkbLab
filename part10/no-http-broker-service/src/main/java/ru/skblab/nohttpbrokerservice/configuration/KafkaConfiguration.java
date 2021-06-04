package ru.skblab.nohttpbrokerservice.configuration;


import org.apache.kafka.common.serialization.LongDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import ru.skblab.nohttpbrokerservice.models.UserInfoShort;
import ru.skblab.nohttpbrokerservice.models.UserState;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfiguration {


    @Bean
    public DefaultKafkaConsumerFactory<Long, UserInfoShort> consumerFactory(KafkaProperties properties) {
        Map<String, Object> props = properties.buildConsumerProperties();
        DefaultKafkaConsumerFactory<Long, UserInfoShort> pf = new DefaultKafkaConsumerFactory<>(props,
                new LongDeserializer(),
                new JsonDeserializer<>(UserInfoShort.class, false)
                        .ignoreTypeHeaders());
        return pf;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<Long, UserInfoShort>
    kafkaListenerContainerFactory(KafkaProperties properties, KafkaTemplate<Long, UserState> template) {

        ConcurrentKafkaListenerContainerFactory<Long, UserInfoShort> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory(properties));
        factory.setReplyTemplate(template);
        return factory;
    }
}
