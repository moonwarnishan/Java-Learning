package com.example.lazyInitialization.Services;

import com.example.lazyInitialization.Interfaces.Coach;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BasketBallCoach implements Coach {
    public BasketBallCoach()
    {
        System.out.println("this is constructor"+getClass().getName());
    }
    @Override
    public String getCoaching() {
        return "BasketBall";
    }
}
