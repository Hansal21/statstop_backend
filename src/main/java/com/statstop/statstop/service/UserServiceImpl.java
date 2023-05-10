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
        User user=userRepository.findByEmail(loginDto.getEmail()).get();
        if(user==null) {
            logger.error("User not found");

            return new ResponseEntity<>("userNotFound",HttpStatus.UNAUTHORIZED);

        }
        if(user.getPassword().equals(loginDto.getPassword())) {
            logger.info("admin logined");
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        logger.error("login failed");

        return new ResponseEntity<>("error",HttpStatus.UNAUTHORIZED);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }
}
