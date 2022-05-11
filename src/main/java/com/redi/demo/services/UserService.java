package com.redi.demo.services;

import com.redi.demo.model.UserRegistration;
import com.redi.demo.repository.UserRepository;
import com.redi.demo.repository.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(final UserRegistration userRegistration) {
        final User user = new User(userRegistration.email, userRegistration.name, userRegistration.password);
        userRepository.save(user);
        return user;
    }
}
