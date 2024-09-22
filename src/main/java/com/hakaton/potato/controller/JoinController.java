//package com.hakaton.potato.controller;
//
//import ch.qos.logback.core.model.Model;
//import com.hakaton.potato.dto.JoinDTO;
//import com.hakaton.potato.service.JoinService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class JoinController {
//
//    private final JoinService joinService;
//
//    public JoinController(JoinService joinService) {
//        this.joinService = joinService;
//    }
//
//    @GetMapping("/join")
//    public String joinP() {
//
//        return "join";
//    }
//
//    @PostMapping("/join")
//    public String joinProcess(JoinDTO joinDTO){
//            joinService.joinProcess(joinDTO);
//            return "redirect:/login";
//    }}
package com.hakaton.potato.controller;

import com.hakaton.potato.dto.JoinDTO;
import com.hakaton.potato.service.JoinService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class JoinController {

    private final JoinService joinService;

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @GetMapping("/join")
    public String joinP() {
        return "join";  // 회원가입 페이지를 반환
    }

    @PostMapping("/join")
    public ResponseEntity<String> joinProcess(@RequestBody JoinDTO joinDTO) {
        String result = joinService.joinProcess(joinDTO);
        return ResponseEntity.ok(result); // 결과를 JSON 형식으로 반환
    }
}
