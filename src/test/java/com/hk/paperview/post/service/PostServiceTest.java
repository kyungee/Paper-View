package com.hk.paperview.post.service;

import com.hk.paperview.account.domain.user.SessionUser;
import com.hk.paperview.account.domain.user.User;
import com.hk.paperview.account.domain.user.UserRepository;
import com.hk.paperview.post.domain.Post;
import com.hk.paperview.post.domain.PostRepository;
import com.hk.paperview.post.dto.PostRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class PostServiceTest {

    @Autowired
    private PostService postService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    private User author;
    private MockHttpSession mockSession;
    private MockHttpServletRequest httpServletRequest;
    private SessionUser sessionUser;

    @BeforeEach
    public void setup() {
        author = User.builder().name("sphong").id("testid").password("testpw").build();
        userRepository.save(author);
        sessionUser = new SessionUser(author);
        mockSession = new MockHttpSession();
        mockSession.setAttribute("user",sessionUser);
        httpServletRequest= new MockHttpServletRequest();
        httpServletRequest.setSession(mockSession);
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(httpServletRequest));
    }


    @AfterEach
    public void teardown() {
        userRepository.deleteAll();
    }
    @Test
    public void 게시글저장() {
        //given
        PostRequestDto requestDto = PostRequestDto.builder().title("testTitle").content("testContent").build();
        //when
        postService.save(requestDto);
        //then
        List<Post> postList = postRepository.findAll();
        assertEquals("sphong", postList.get(0).getUser().getName());
    }

}