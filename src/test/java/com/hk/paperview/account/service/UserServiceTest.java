package com.hk.paperview.account.service;

import com.hk.paperview.account.domain.user.User;
import com.hk.paperview.account.domain.user.UserRepository;
import com.hk.paperview.account.dto.SignUpRequestDto;
import com.hk.paperview.account.dto.SignUpResponseDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    //TODO: need to fix
    private Long savedId = 2L;

    @AfterEach
    public void tearDown() {
        userRepository.deleteById(savedId);
    }
    @Test
    public void 회원가입_성공() {
        //given
        SignUpRequestDto requestDto = SignUpRequestDto.builder().id("testId").password("testPw").name("testName").build();
        //when
        SignUpResponseDto responseDto = userService.save(requestDto);
        //then
        assertEquals("testName", responseDto.getName());
    }
}