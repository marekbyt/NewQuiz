package com.example.newquiz.controller;

import com.example.newquiz.model.CalculatorData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "index";

    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
    @GetMapping("/welcome")
    public String welcome(@RequestParam String name, int age,  Model model ){
        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "welcome";

    }
    @GetMapping("/calc")

    public String calculator(@RequestParam double a,
                             @RequestParam double b,
                             @RequestParam (defaultValue = "add") String op, Model model){

        CalculatorData calculatorData = CalculatorData
                .builder()
                .operator(op)
                .a(a)
                .b(b)
                .build();
        model.addAttribute("calculatorData", calculatorData);
        return "calculator";

    }
}
