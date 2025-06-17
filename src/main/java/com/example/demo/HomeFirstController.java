package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeFirstController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("first")
    public String first() {
        return "first";
    }

    @GetMapping("second")
    public String second() {
        return "first";
    }
}
