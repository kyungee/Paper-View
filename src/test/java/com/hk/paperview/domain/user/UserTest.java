package com.hk.paperview.domain.user;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserTest {

    @Autowired
    private UserRepository userRepository;

    @AfterAll
    public void tearDown() {
        userRepository.deleteById(2L);
    }

    @Test
    public void test_DefaultUserInfo() {
        //given
        String defaultName = "defaultName";

        //when
        List<User> userList = userRepository.findAll();

        //then
        assertEquals(userList.get(0).getName(),defaultName);
    }

    @Test
    public void test_addUser() {
        //given
        String id = "testID";
        String password = "testPW";
        String name = "testName";

        //when
        userRepository.save(User.builder().id(id).password(password).name(name).build());

        //then
        List<User> defaultUserList =  userRepository.findAll();
        assertEquals(defaultUserList.get(1).getId(),"testID");
    }
}