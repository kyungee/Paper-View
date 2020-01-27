package com.hk.paperview.post.service;

import com.hk.paperview.account.domain.user.SessionUser;
import com.hk.paperview.account.domain.user.User;
import com.hk.paperview.account.domain.user.UserRepository;
import com.hk.paperview.post.domain.Post;
import com.hk.paperview.post.domain.PostRepository;
import com.hk.paperview.post.dto.PostRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final HttpSession httpSession;

    public PostService(PostRepository postRepository, UserRepository userRepository, HttpSession httpSession) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.httpSession = httpSession;
    }

    @Transactional
    public Long save(PostRequestDto requestDto) {
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        String userName = sessionUser.getUserName();
        User author = userRepository.findByName(userName).orElseThrow(()->new IllegalArgumentException("User Not Found"));
        Post post = Post.builder().title(requestDto.getTitle()).content(requestDto.getContent()).user(author).build();

        author.addPost(post);
        userRepository.save(author);
        return postRepository.save(post).getIdx();
    }
}
