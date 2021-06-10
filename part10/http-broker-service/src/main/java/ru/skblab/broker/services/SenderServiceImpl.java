package ru.skblab.broker.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.stereotype.Service;
import ru.skblab.broker.configuration.AppProperties;
import ru.skblab.broker.dto.UserToBroker;
import ru.skblab.broker.dto.UserStateFromBroker;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Service
public class SenderServiceImpl implements SenderService {

    private final ReplyingKafkaTemplate<Long, UserToBroker, UserStateFromBroker>  template;
    private final AppProperties properties;

    public SenderServiceImpl(ReplyingKafkaTemplate<Long, UserToBroker, UserStateFromBroker> template,
                             AppProperties properties) {
        this.template = template;
        this.properties = properties;
    }

    public UserStateFromBroker sendAndReceiveMessage(Long id, UserToBroker userToBroker)
            throws ExecutionException, InterruptedException, TimeoutException {
        ProducerRecord<Long, UserToBroker> record = new ProducerRecord<>(properties.getTopicRequest(),
                id, userToBroker);
        RequestReplyFuture<Long, UserToBroker, UserStateFromBroker> replyMessageFuture = template.sendAndReceive(record);
        ConsumerRecord<Long, UserStateFromBroker> consumerRecord =  replyMessageFuture.completable().get();
        return consumerRecord.value();
    }
}
