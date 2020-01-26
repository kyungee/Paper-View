package com.hk.paperview.account.service;

import com.hk.paperview.account.domain.user.SessionUser;
import com.hk.paperview.account.domain.user.User;
import com.hk.paperview.account.domain.user.UserRepository;
import com.hk.paperview.account.dto.LoginRequestDto;
import com.hk.paperview.account.dto.LoginResponseDto;
import com.hk.paperview.account.dto.SignUpRequestDto;
import com.hk.paperview.account.dto.SignUpResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final HttpSession httpSession;

    public SignUpResponseDto save(SignUpRequestDto requestDto) {
        String id = requestDto.getId();
        String password = requestDto.getPassword();
        String name = requestDto.getName();
        User savedUser = userRepository.save(User.builder().id(id).password(password).name(name).build());
        return SignUpResponseDto.builder().name(savedUser.getName()).build();
    }

    public Object loadUser(LoginRequestDto requestDto) {
        User loadUser = userRepository.findById(requestDto.getId()).orElseThrow( () -> new IllegalArgumentException("가입되지 않은 유저"));
//        if (!loadUser.getPassword().equals(requestDto.getPassword())) {
//            return null;
//        }
        SessionUser sessionUser = new SessionUser(loadUser);
        httpSession.setAttribute("user",sessionUser);
        return LoginResponseDto.builder().userName(loadUser.getName()).build();
    }
}
