package ru.skblab.broker.db.services;

import org.springframework.stereotype.Service;
import ru.skblab.broker.db.models.UserState;
import ru.skblab.broker.db.repository.UserStateRepository;

@Service
public class UserStateService {

    private final UserStateRepository userStateRepository;

    public UserStateService(UserStateRepository userStateRepository) {
        this.userStateRepository = userStateRepository;
    }

    public UserState saveAndGet(UserState userState){
        return userStateRepository.save(userState);
    }
}
