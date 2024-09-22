package com.hakaton.potato.controller;

import com.hakaton.potato.entity.UserEntity;
import com.hakaton.potato.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {

    @GetMapping("/mypage")
    public String mypP() {

        return "mypage";
    }
}