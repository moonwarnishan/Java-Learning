package com.example.PrimaryAndQualifier.Services;

import com.example.PrimaryAndQualifier.Interfaces.Coach;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CricketCoach implements Coach {
    @Override
    public String getCoaching() {
        return "Cricket";
    }
}
