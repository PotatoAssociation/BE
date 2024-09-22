package com.hakaton.potato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RewardController {

    @GetMapping("/reward")
    public String rewardP() {

        return "reward";
    }
}
