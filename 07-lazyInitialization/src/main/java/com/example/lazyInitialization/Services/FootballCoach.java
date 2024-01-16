package com.example.lazyInitialization.Services;

import com.example.lazyInitialization.Interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {
    public FootballCoach()
    {
        System.out.println("this is constructor"+getClass().getName());
    }
    @Override
    public String getCoaching() {
        return "Football";
    }
}
