package ru.skblab.nohttpbrokerservice.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;
import ru.skblab.nohttpbrokerservice.configuration.KafkaConfiguration;
import ru.skblab.nohttpbrokerservice.models.UserInfoShort;
import ru.skblab.nohttpbrokerservice.models.UserState;

import java.time.LocalDateTime;

@Service
public class ReceiverServiceImpl implements ReceiverService {


    @Override
    @KafkaListener(topics = "USER_INFO_REQUEST")
    @SendTo
    public UserState listen(UserInfoShort userInfoShort) {
        return new UserState(userInfoShort.getId(),
                "VALID",
                LocalDateTime.now(),
                "Должник");
    }
}
