package com.hk.paperview.account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpRequestDto {
    public String id;
    public String password;
    public String name;

    @Builder
    public SignUpRequestDto(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }
}
