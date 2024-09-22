package com.hakaton.potato.service;

import com.hakaton.potato.entity.UserEntity;
import com.hakaton.potato.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;  // 비밀번호 암호화 사용

    public LoginService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean login(String username, String email, String password) {
        // 데이터베이스에서 해당 닉네임과 이메일을 가진 유저 찾기
        UserEntity user = userRepository.findByUsername(username);

        // 유저가 존재하고, 비밀번호가 일치하는지 확인
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return true;  // 로그인 성공
        }
        return false;  // 로그인 실패
    }
}

