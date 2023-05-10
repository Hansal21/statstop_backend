package com.statstop.statstop.service;

import com.statstop.statstop.dto.LoginDto;
import com.statstop.statstop.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<Object> login(LoginDto loginDto);

    User findUserByEmail(String email);
}
