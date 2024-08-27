package org.example.taskfordevop.service;

import org.example.taskfordevop.dtos.requests.RegisterUserRequests;
import org.example.taskfordevop.dtos.response.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse register(RegisterUserRequests requests);
}
