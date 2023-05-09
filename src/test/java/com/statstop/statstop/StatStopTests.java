package com.statstop.statstop;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import com.statstop.statstop.dto.LoginDto;
import com.statstop.statstop.entity.User;
import com.statstop.statstop.repository.UserRepository;
import com.statstop.statstop.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class StatStopTests {

    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void testLogin() {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("hansal@gmail.com");
        loginDto.setPassword("hansal");
        User user = new User();
        user.setEmail("hansal@gmail.com");
        user.setPassword("hansal");
        when(userRepository.findByEmail(loginDto.getEmail())).thenReturn(user);
        ResponseEntity<Object> responseEntity = userService.login(loginDto);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user, responseEntity.getBody());
    }

}

