package ru.skblab.broker.configuration;

import org.apache.kafka.common.serialization.LongDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import ru.skblab.broker.models.UserInfoShort;
import ru.skblab.broker.models.UserState;

import java.util.Map;


@Configuration
@EnableKafka
public class KafkaConfiguration {

    private final AppProperties properties;

    public KafkaConfiguration(AppProperties properties) {
        this.properties = properties;
    }

    @Bean
    public ConcurrentMessageListenerContainer<Long, UserState> repliesContainer(
            ConcurrentKafkaListenerContainerFactory<Long, UserState> containerFactory) {

        ConcurrentMessageListenerContainer<Long, UserState> repliesContainer =
                containerFactory.createContainer(properties.getTopicReply());
        repliesContainer.getContainerProperties().setGroupId(properties.getGroupId());
        repliesContainer.setAutoStartup(false);
        return repliesContainer;
    }

    @Bean
    public ReplyingKafkaTemplate<Long, UserInfoShort, UserState> replyingTemplate(
            ProducerFactory<Long, UserInfoShort> pf,
            ConcurrentMessageListenerContainer<Long, UserState> repliesContainer) {

        return new ReplyingKafkaTemplate<>(pf, repliesContainer);
    }

    @Bean
    public StringJsonMessageConverter jsonConverter() {
        return new StringJsonMessageConverter();
    }

    @Bean
    public DefaultKafkaConsumerFactory<Long, UserState> consumerFactory(KafkaProperties properties) {
        Map<String, Object> props = properties.buildConsumerProperties();
        DefaultKafkaConsumerFactory<Long, UserState> pf = new DefaultKafkaConsumerFactory<>(props,
                new LongDeserializer(),
                new JsonDeserializer<>(UserState.class)
                        .ignoreTypeHeaders());
        return pf;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<Long, UserState>
    kafkaListenerContainerFactory(KafkaProperties properties) {

        ConcurrentKafkaListenerContainerFactory<Long, UserState> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory(properties));
        return factory;
    }
}
