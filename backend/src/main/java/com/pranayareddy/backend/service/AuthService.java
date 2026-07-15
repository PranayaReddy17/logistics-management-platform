package com.pranayareddy.backend.service;

import com.pranayareddy.backend.dto.request.LoginRequest;
import com.pranayareddy.backend.dto.request.RegisterRequest;

public interface AuthService {

    String register(RegisterRequest request);
    String login(LoginRequest request);
}