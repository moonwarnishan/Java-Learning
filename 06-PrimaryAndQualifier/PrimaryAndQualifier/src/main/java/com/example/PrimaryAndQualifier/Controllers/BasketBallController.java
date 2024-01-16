package com.example.PrimaryAndQualifier.Controllers;

import com.example.PrimaryAndQualifier.Interfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasketBallController {
    private final Coach coach;
    @Autowired
    public BasketBallController(@Qualifier("basketBallCoach") Coach theCoach)
    {
        coach = theCoach;
    }
    @GetMapping("/basketball")
    public String basketball()
    {
        return coach.getCoaching();
    }
}
