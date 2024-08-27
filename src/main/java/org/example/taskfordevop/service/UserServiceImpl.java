package org.example.taskfordevop.service;

import org.example.taskfordevop.data.model.User;
import org.example.taskfordevop.data.repository.UserRepository;
import org.example.taskfordevop.dtos.exception.BaseException;
import org.example.taskfordevop.dtos.requests.RegisterUserRequests;
import org.example.taskfordevop.dtos.response.RegisterUserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RegisterUserResponse register(RegisterUserRequests requests) {
        if (userRepository.existsByEmail(requests.getEmail().strip())) {
            throw new BaseException("User already registered, just log in");
        }
        User user = modelMapper.map(requests, User.class);
        user.setFirstName(requests.getFirstName());
        user.setLastName(requests.getLastName());
        user.setPassword(requests.getPassword());
        user.setGender(requests.getGender());
        user.setEmail(requests.getEmail());
        user.setPhoneNumber(requests.getPhoneNumber());
        User userTobeRegistered = userRepository.save(user);
        RegisterUserResponse response = modelMapper.map(userTobeRegistered, RegisterUserResponse.class);
        response.setMessage("Registration successful, please log in");
        return response;
    }
}
