package com.example.PrimaryAndQualifier.Controllers;

import com.example.PrimaryAndQualifier.Interfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CricketController {
    private final Coach coach;
    @Autowired
    CricketController(Coach theCoach)
    {
        coach = theCoach;
    }

    @GetMapping("/cricket")
    public String getCricket()
    {
        return coach.getCoaching();
    }
}
