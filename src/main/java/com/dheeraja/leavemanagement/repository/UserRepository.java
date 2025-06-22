package com.dheeraja.leavemanagement.repository;

import com.dheeraja.leavemanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUserIdAndPassword(String userId, String password);
}