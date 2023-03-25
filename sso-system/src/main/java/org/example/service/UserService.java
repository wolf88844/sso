package org.example.service;

import org.example.entity.User;

import java.util.List;

public interface UserService {
    User selectUserByUsername(String username);
    List<String> selectUserPermissions(Long userId);
}
