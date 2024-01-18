package com.example.jwtDemo.Controller;

import com.example.jwtDemo.Model.User;
import com.example.jwtDemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class DemoController {
    private UserService userService;

    @Autowired
    public DemoController(UserService userService) {
        this.userService = userService;
    }

    @Autowired

    @GetMapping("")
    private List<User> GetUser()
    {
        return userService.getUsers();
    }
}
