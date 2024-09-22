package com.hakaton.potato.service;

import com.hakaton.potato.dto.JoinDTO;
import com.hakaton.potato.entity.UserEntity;
import com.hakaton.potato.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public String joinProcess(JoinDTO joinDTO){

        String username=joinDTO.getUsername();
        String email=joinDTO.getEmail();
        String password=joinDTO.getPassword();

        Boolean isExist = userRepository.existsByUsername(username);
        Boolean isExistEmail =  userRepository.existsByEmail(email);

        if(isExist){
            return "이미 존재하는 닉네임입니다.";
        }

        if(isExistEmail){
            return "이미 존재하는 이메일입니다.";
        }

        UserEntity data = new UserEntity();

        data.setUsername(username);
        data.setEmail(email);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setUserpoint(0);
        data.setRole("ROLE_USER"); //역할지정

        userRepository.save(data);
        return "회원가입성공";
    }
}
