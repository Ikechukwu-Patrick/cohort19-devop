package org.example.taskfordevop.controller;

import org.example.taskfordevop.data.model.User;
import org.example.taskfordevop.dtos.exception.BaseException;
import org.example.taskfordevop.dtos.requests.RegisterUserRequests;
import org.example.taskfordevop.dtos.response.RegisterUserResponse;
import org.example.taskfordevop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> registerUser(@RequestBody RegisterUserRequests requests) {
        try {
            RegisterUserResponse response = userService.register(requests);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (BaseException e) {
            RegisterUserResponse response = new RegisterUserResponse();
            response.setMessage("Registration successful");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}




