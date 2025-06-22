package com.dheeraja.leavemanagement.service;

import com.dheeraja.leavemanagement.model.User;

public interface UserService {
    User login(String userId, String password);
}