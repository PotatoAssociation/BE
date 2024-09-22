package com.hakaton.potato.service;

import com.hakaton.potato.entity.UserEntity;
import com.hakaton.potato.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity getUserByUsername(String username) {
        // 사용자 정보가 없을 경우 null 반환
        return userRepository.findByUsername(username);
    }
}
