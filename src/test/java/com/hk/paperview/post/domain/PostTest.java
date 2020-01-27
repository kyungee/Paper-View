package com.hk.paperview.post.domain;

import com.hk.paperview.account.domain.user.User;
import com.hk.paperview.account.domain.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class PostTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    public void tearDown() {
        userRepository.deleteAll();
        postRepository.deleteAll();
    }
    @Test
    public void 유저_게시글_저장_성공() {
        //given
        User user = User.builder().id("testId").password("testPw").name("sphong").build();
        Post post = Post.builder().title("testTitle").content("testContent").user(user).build();

        user.addPost(post);

        //when
        userRepository.save(user);
        postRepository.save(post);
        //then
        List<Post> postList = postRepository.findAll();
        List<User> userList = userRepository.findAll();
        assertEquals("sphong", postList.get(0).getUser().getName());
        assertEquals(1, userList.get(0).getPostsList().size());
    }

    @Test
    public void 게시글_2개_저장() {
        //given
        User user = User.builder().id("testId").password("testPw").name("sphong").build();
        Post post1 = Post.builder().title("testTitle").content("testContent").user(user).build();
        Post post2 = Post.builder().title("testTitle2").content("testContent2").user(user).build();
        user.addPost(post1);
        user.addPost(post2);

        //when
        userRepository.save(user);
        postRepository.save(post1);
        postRepository.save(post2);

        //then
        List<Post> postList = postRepository.findAll();
        List<User> userList = userRepository.findAll();
        assertEquals("sphong", postList.get(1).getUser().getName());
        assertEquals(2, userList.get(0).getPostsList().size());
    }
}