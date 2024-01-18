package com.example.jwtDemo.Service;

import com.example.jwtDemo.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User(1,"1","1"));
        users.add(new User(2,"2","2"));
        users.add(new User(3,"3","3"));
        users.add(new User(4,"4","4"));
    }

    public List<User> getUsers()
    {
        return this.users;
    }
}
