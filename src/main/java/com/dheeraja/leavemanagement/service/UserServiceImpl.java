package com.dheeraja.leavemanagement.service;

import com.dheeraja.leavemanagement.model.User;
import com.dheeraja.leavemanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String userId, String password) {
        return userRepository.findByUserIdAndPassword(userId, password);
    }
}