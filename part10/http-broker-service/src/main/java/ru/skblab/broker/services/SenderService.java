package ru.skblab.broker.services;

import ru.skblab.broker.models.UserInfoShort;
import ru.skblab.broker.models.UserState;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public interface SenderService {

    UserState sendAndReceiveMessage(Long id, UserInfoShort userInfoShort)
            throws ExecutionException, InterruptedException, TimeoutException;

}
