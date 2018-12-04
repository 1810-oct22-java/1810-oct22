package com.ex.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public String home(){
        return "Welcome to Spring MVC!";
    }
}