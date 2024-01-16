package com.example.lazyInitialization.Controllers;

import com.example.lazyInitialization.Interfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CricketController {
    private final Coach coach;
    @Autowired
    CricketController(@Qualifier("cricketCoach") Coach theCoach)
    {
        coach = theCoach;
        System.out.println("this is constructor"+getClass().getName());
    }

    @GetMapping("/cricket")
    public String getCricket()
    {
        return coach.getCoaching();
    }
}
