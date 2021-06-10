package ru.skblab.nohttpbrokerservice.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;
import ru.skblab.nohttpbrokerservice.models.UserFromBroker;
import ru.skblab.nohttpbrokerservice.models.UserStateToBroker;

import java.time.LocalDateTime;

@Service
public class ReceiverServiceImpl implements ReceiverService {


    @Override
    @KafkaListener(topics = "USER_INFO_REQUEST")
    @SendTo
    public UserStateToBroker listen(UserFromBroker userFromBroker) {
        return new UserStateToBroker(userFromBroker.getId(),
                "VALID",
                LocalDateTime.now(),
                "Должник");
    }
}
