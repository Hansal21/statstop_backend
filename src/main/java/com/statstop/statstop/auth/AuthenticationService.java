package com.statstop.statstop.auth;

import com.statstop.statstop.config.JwtService;
import com.statstop.statstop.entity.Role;
import com.statstop.statstop.entity.Token;
import com.statstop.statstop.entity.TokenType;
import com.statstop.statstop.entity.User;
import com.statstop.statstop.repository.TokenRepository;
import com.statstop.statstop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Base64;

@Service
    @RequiredArgsConstructor
    public class AuthenticationService {
        private final UserRepository repository;
        private final TokenRepository tokenRepository;

        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        var user= User.builder()
                .firstName(request.getFirstName())
                .secondName(request.getSecondName())
                .email(request.getEmail())
                .role(Role.ADMIN)
                .password(this.passwordEncoder.encode(request.getPassword()))
                .build();

        var savedUser=repository.save(user);
        var jwtToken=jwtService.generateToken(user,Role.ADMIN);
        String data = String.valueOf(savedUser.getUserId());
//        savedUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken=jwtService.generateToken(user,user.getRole());
        revokeAllUserTokens(user);
        savedUserToken(user,jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private void revokeAllUserTokens(User user){
        var validUserToken = tokenRepository.findAllValidTokenByUser(user.getUserId());
        if(validUserToken.isEmpty())
            return;
        validUserToken.forEach(t -> {
            t.setExpired(true);
            t.setRevoked(true);
        });
        tokenRepository.saveAll(validUserToken);

    }

    private void savedUserToken(User user, String jwtToken) {
        var token= Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .build();

        tokenRepository.save(token);
    }

    }

