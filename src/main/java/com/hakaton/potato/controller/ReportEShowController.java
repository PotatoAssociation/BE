package com.hakaton.potato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportEShowController {

    @GetMapping("/reportEshow")
    public String adminP() {

        return "reportEshow";
    }
}