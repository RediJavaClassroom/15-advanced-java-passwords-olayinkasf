package com.redi.demo.services;

import com.redi.demo.model.UserRegistration;
import com.redi.demo.repository.UserRepository;
import com.redi.demo.repository.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(final UserRepository userRepository, final PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User createUser(final UserRegistration userRegistration) {
        final User user = new User(userRegistration.email, userRegistration.name, passwordEncoder.encode(userRegistration.password));
        userRepository.save(user);
        return user;
    }

    public User getUser(final String email) {
        return userRepository.findByEmail(email);
    }
}
