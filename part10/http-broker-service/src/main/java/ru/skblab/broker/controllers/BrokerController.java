package ru.skblab.broker.controllers;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.skblab.broker.db.models.User;
import ru.skblab.broker.db.models.UserState;
import ru.skblab.broker.db.services.UserService;
import ru.skblab.broker.db.services.UserStateService;
import ru.skblab.broker.dto.UserStateResponseDto;
import ru.skblab.broker.dto.UserRequestDto;
import ru.skblab.broker.dto.UserStateFromBroker;
import ru.skblab.broker.dto.mappers.UserMapper;
import ru.skblab.broker.dto.mappers.UserStateMapper;
import ru.skblab.broker.services.SenderService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;


@RestController
public class BrokerController {

    private final SenderService senderService;
    private final UserMapper userMapper;
    private final UserStateMapper userStateMapper;
    private final UserService userService;
    private final UserStateService userStateService;

    public BrokerController(SenderService senderService,
                            UserMapper userMapper,
                            UserStateMapper userStateMapper,
                            UserService userService,
                            UserStateService userStateService) {
        this.senderService = senderService;
        this.userMapper = userMapper;
        this.userStateMapper = userStateMapper;
        this.userService = userService;
        this.userStateService = userStateService;
    }

    @PostMapping("/getState")
    @Operation(summary = "Get information about user")
    public UserStateResponseDto getStateUser(@RequestBody UserRequestDto userRequestDto) {
        try{
            User user = userService.saveAndGet(userMapper.userDtoRequestToEntity(userRequestDto));
            UserStateFromBroker receiveMessageBroker = senderService.sendAndReceiveMessage(user.getId(),
                    userMapper.userEntityToMessageBroker(user));
            UserState userState = userStateService
                    .saveAndGet(userStateMapper.UserStateFromBrokerToEntity(receiveMessageBroker));
            return userStateMapper.UserStateEntityToResponseDto(userState);
        } catch (InterruptedException | TimeoutException | ExecutionException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

}
