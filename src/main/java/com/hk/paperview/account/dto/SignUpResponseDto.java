package com.hk.paperview.account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpResponseDto {
    private String name;
    @Builder
    public SignUpResponseDto (String name) {
        this.name = name;
    }
}
