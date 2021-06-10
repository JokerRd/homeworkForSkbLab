package ru.skblab.broker.services;

import ru.skblab.broker.dto.UserToBroker;
import ru.skblab.broker.dto.UserStateFromBroker;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public interface SenderService {

    UserStateFromBroker sendAndReceiveMessage(Long id, UserToBroker userToBroker)
            throws ExecutionException, InterruptedException, TimeoutException;

}
