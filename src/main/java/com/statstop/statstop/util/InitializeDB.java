package com.statstop.statstop.util;

import com.statstop.statstop.entity.User;
import com.statstop.statstop.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitializeDB {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            // This config is used to create admin user only for the first time...
            User admin = new User();
            admin.setFirstName("Hansal");
            admin.setSecondName("Dhadnha");
            admin.setEmail("hansal@gmail.com");
            admin.setPassword("hansal");
            if(userRepository.findByEmail(admin.getEmail())==null)
                userRepository.save(admin);
        };
    }
}
