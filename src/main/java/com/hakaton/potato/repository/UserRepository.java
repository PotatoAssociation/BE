package com.hakaton.potato.repository;

import com.hakaton.potato.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
        Boolean existsByUsername(String username);
        Boolean existsByEmail(String email);
        UserEntity findByUsername(String username);
}
