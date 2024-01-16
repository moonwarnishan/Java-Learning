package com.lub2code.springboot.demo.mycoolapp.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
    // expose "/" return "Hello World"
    @GetMapping("/")
    public String sayHello()
    {
        return "Hello World Hyelellele";
    }
}
