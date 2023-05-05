package com.statstop.statstop.service;

import com.statstop.statstop.dto.LoginDto;
import com.statstop.statstop.entity.User;
import com.statstop.statstop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private static final Logger logger= LogManager.getLogger(UserServiceImpl.class);

    @Override
    public ResponseEntity<Object> login(LoginDto loginDto) {
        User user=userRepository.findByEmail(loginDto.getEmail());
        if(user==null) return new ResponseEntity<>("userNotFound",HttpStatus.UNAUTHORIZED);
        if(user.getPassword()!=loginDto.getPassword())
            return new ResponseEntity<>(user, HttpStatus.OK);
        return new ResponseEntity<>("error",HttpStatus.UNAUTHORIZED);
    }
}
