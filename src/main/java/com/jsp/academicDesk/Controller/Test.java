package com.jsp.academicDesk.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/academicdesk/auth")
public class Test {

    @GetMapping("/test")
    public String hello(){
        return "hello";
    }
}
