package com.hk.paperview.post.controller;

import com.hk.paperview.post.dto.PostRequestDto;
import com.hk.paperview.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostApiController {

    @Autowired
    private PostService postService;

    @PostMapping("/posts")
    public Long savePost(@RequestBody PostRequestDto requestDto) {
        return postService.save(requestDto);
    }
}
