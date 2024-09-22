package com.hakaton.potato.controller;

import com.hakaton.potato.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletResponse; // jakarta.servlet.http로 변경해야 합니다
import java.io.IOException;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String loginP() {

        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                                        @RequestParam String email,
                                        @RequestParam String password) {
        boolean isSuccess = loginService.login(username, email, password);

        if (isSuccess) {

            return "redirect:/mypage";
        } else {
            return "redirect:/login?error=true";
        }
    }
}
