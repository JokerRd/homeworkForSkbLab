package ru.skblab.broker.controllers;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.skblab.broker.db.models.User;
import ru.skblab.broker.models.UserInfoShort;
import ru.skblab.broker.models.UserState;
import ru.skblab.broker.services.SenderService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;


@RestController
public class BrokerController {

    private final SenderService senderService;

    public BrokerController(SenderService senderService) {
        this.senderService = senderService;
    }

    @PostMapping("/getState")
    @Operation(summary = "Get information about user")
    public UserState getStateUser( @RequestBody User user) {
        try{
            UserState userState = senderService.sendAndReceiveMessage(user.getId(),
                    new UserInfoShort(user.getId(), user.getName(), user.getPhoneNumber()));
            return userState;
        } catch (InterruptedException | TimeoutException | ExecutionException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

}
