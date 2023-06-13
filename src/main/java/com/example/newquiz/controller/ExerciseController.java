package com.example.newquiz.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class ExerciseController {
    @RequestMapping(path="/hello", method = RequestMethod.GET)
    public void sendHello (HttpServletRequest request , HttpServletResponse response) throws IOException {
        final String name = request.getParameter("name");
        final String  age = request.getParameter("24");
        response.setStatus(200);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        final PrintWriter writer = response.getWriter();
        writer.println("Hi " + name + " , you are " + age + " years old");

    }
    @GetMapping("/powitanie")
    @ResponseBody
    public String sendWelcome(@RequestParam(name = "user-name", defaultValue = "anonim") String name,
                              @RequestParam(required = false) Integer age
    ){
    return age == null ? "Czesc " + name : "Czesc " + " , masz " + age + " lat";
    }



}
