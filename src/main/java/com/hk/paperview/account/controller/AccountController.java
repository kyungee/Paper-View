package com.hk.paperview.account.controller;

import com.hk.paperview.account.dto.LoginRequestDto;
import com.hk.paperview.account.dto.LoginResponseDto;
import com.hk.paperview.account.dto.SignUpRequestDto;
import com.hk.paperview.account.dto.SignUpResponseDto;
import com.hk.paperview.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public SignUpResponseDto signup(@RequestBody SignUpRequestDto requestDto) {
        return userService.save(requestDto);
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto requestDto) {
        return (LoginResponseDto) userService.loadUser(requestDto);
    }
}
