package com.pranayareddy.backend.service;

import com.pranayareddy.backend.dto.request.CreateUserRequest;
import com.pranayareddy.backend.dto.response.UserResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    UserResponse createUser(CreateUserRequest request);

    Page<UserResponse> getAllUsers(
            int page,
            int size,
            String sortBy,
            String direction);

    UserResponse getUserById(Long id);

    UserResponse updateUser(Long id, CreateUserRequest request);

    void deleteUser(Long id);

    UserResponse getUserByEmail(String email);
}