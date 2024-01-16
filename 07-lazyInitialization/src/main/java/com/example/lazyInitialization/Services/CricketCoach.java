package com.example.lazyInitialization.Services;

import com.example.lazyInitialization.Interfaces.Coach;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach()
    {
        System.out.println("this is constructor"+getClass().getName());
    }
    @Override
    public String getCoaching() {
        return "Cricket";
    }
}
