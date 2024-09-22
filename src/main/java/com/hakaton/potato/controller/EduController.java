package com.hakaton.potato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EduController {

    @GetMapping("/edu")
    public String adminP() {

        return "edu";
    }
}
