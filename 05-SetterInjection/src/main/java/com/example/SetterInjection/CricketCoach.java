package com.example.SetterInjection;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getCoachingDetails() {
        return "This is Cricket Coach";
    }
}
