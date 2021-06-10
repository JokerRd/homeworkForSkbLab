package ru.skblab.broker.db.services;

import org.springframework.stereotype.Service;
import ru.skblab.broker.db.models.User;
import ru.skblab.broker.db.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveAndGet(User user) {
        return userRepository.save(user);
    }


}
