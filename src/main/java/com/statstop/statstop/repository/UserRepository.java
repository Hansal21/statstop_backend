package com.statstop.statstop.repository;

import com.statstop.statstop.dto.LoginDto;
import com.statstop.statstop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
