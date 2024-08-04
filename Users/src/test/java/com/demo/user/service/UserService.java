package com.demo.user.service;

import java.util.List;
import java.util.Optional;

import com.demo.user.model.UserModel;

public interface UserService {
    UserModel createUser(UserModel user);
    List<UserModel> getAllUsers();
    Optional<UserModel> updateUser(String email, UserModel userDetails);
    boolean deleteUser(String email);
}
