package com.example.PrimaryAndQualifier.Services;

import com.example.PrimaryAndQualifier.Interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class BasketBallCoach implements Coach {
    @Override
    public String getCoaching() {
        return "BasketBall";
    }
}
