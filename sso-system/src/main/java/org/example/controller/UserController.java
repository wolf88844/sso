package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login/{username}")
    public User doSelectUserByUsername(@PathVariable("username")String username){
        return userService.selectUserByUsername(username);
    }
    @GetMapping("/permission/{userId}")
    public List<String> doSelectUserPermissions(@PathVariable("userId")Long userId){
        return userService.selectUserPermissions(userId);
    }
}
