package com.example.PrimaryAndQualifier.Controllers;

import com.example.PrimaryAndQualifier.Interfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FootballController {
    private final Coach coach;
    @Autowired
    public FootballController(@Qualifier("footballCoach") Coach theCoach)
    {
        coach = theCoach;
    }

    @GetMapping("/football")
    public String football()
    {
        return coach.getCoaching();
    }
}
