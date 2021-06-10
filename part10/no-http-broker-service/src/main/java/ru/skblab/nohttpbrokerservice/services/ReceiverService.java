package ru.skblab.nohttpbrokerservice.services;


import ru.skblab.nohttpbrokerservice.models.UserFromBroker;
import ru.skblab.nohttpbrokerservice.models.UserStateToBroker;

public interface ReceiverService {

    UserStateToBroker listen(UserFromBroker userFromBroker);
}
