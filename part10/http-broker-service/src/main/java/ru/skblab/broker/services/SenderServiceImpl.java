package ru.skblab.broker.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.stereotype.Service;
import ru.skblab.broker.configuration.AppProperties;
import ru.skblab.broker.models.UserInfoShort;
import ru.skblab.broker.models.UserState;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Service
public class SenderServiceImpl implements SenderService {

    private final ReplyingKafkaTemplate<Long, UserInfoShort, UserState>  template;
    private final AppProperties properties;

    public SenderServiceImpl(ReplyingKafkaTemplate<Long, UserInfoShort, UserState> template,
                             AppProperties properties) {
        this.template = template;
        this.properties = properties;
    }

    public UserState sendAndReceiveMessage(Long id, UserInfoShort userInfoShort)
            throws ExecutionException, InterruptedException, TimeoutException {
        ProducerRecord<Long, UserInfoShort> record = new ProducerRecord<>(properties.getTopicRequest(),
                id, userInfoShort);
        RequestReplyFuture<Long, UserInfoShort, UserState> replyMessageFuture = template.sendAndReceive(record);
        ConsumerRecord<Long, UserState> consumerRecord =  replyMessageFuture.completable().get();
        return consumerRecord.value();
    }
}
