package com.codeup.blog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String landingPage() {
        return "This is a landing page";
    }
    @GetMapping("/roll-dice/")
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2){
        return (num1 + " + " + num2 + " = " + (num1 + num2));
    }
}
