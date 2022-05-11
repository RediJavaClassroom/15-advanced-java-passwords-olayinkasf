package com.redi.demo.controller;

import com.redi.demo.model.UserRegistration;
import com.redi.demo.repository.UserRepository;
import com.redi.demo.repository.model.User;
import com.redi.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(final UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping(path = "/users/{email}")
    @ResponseBody
    public User get(@PathVariable final String email ) {
        return userRepository.findById(email).get();
    }


    @PostMapping(path = "/users")
    @ResponseBody
    public User createUser(@RequestBody final UserRegistration userRegistration){
        return userService.createUser(userRegistration);
    }

}
