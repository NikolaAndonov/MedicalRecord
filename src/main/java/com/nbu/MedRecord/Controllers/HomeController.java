package com.nbu.MedRecord.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/patient")
    public String patient() {
        return "patient";
    }

    @RequestMapping("/doctor")
    public String doctor() {
        return "doctor";
    }

    @RequestMapping("/profile")
    public String profile() {
        return "profile";
    }

}

