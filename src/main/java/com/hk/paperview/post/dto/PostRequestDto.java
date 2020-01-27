package com.hk.paperview.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequestDto {
    private String title;
    private String content;

    @Builder
    public PostRequestDto (String title, String content) {
        this.title = title;
        this.content = content;
    }
}
