package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello from Spring!";
    }

    @GetMapping("/math/pi")
    public String returnPi() {
        return "3.141592653589793";
    }

    @GetMapping("/math/calculate")
    public String returnOperation(
        @RequestParam("operation") String operator,
        @RequestParam("x") int x,
        @RequestParam("y") int y) {
        switch(operator) {
            case "add":
                return x + " + " + y + " = " + (x + y);
            case "subtract":
                return x + " - " + y + " = " + (x - y);
            case "multiply":
                return x + " * " + y + " = " + (x * y);
            case "divide":
                if (y != 0) {
                    return x + " / " + y + " = " + (x / y);
                } else {
                    return "Error";
                }
            default:
                return "Enter a valid operation type";
        }
    }
}