package com.hk.paperview.account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginResponseDto {
    private String userName;
    @Builder
    public LoginResponseDto (String userName) {
        this.userName = userName;
    }
}
