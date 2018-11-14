package com.example.service;

import com.example.model.User;
import com.example.service.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by baota on 2017/4/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {
    //@Autowired
    private UserService userService;

    @Value("${aa:77}")
    private String aa;

    @Test
    public void insertTest() {
        User user = User.builder()
                .account("12345")
                .nickname("bbb")
                .type("1")
                .mobile("13545654456")
                .telephone("8013191")
                .superiorAccount("heiqie2")
                .organizationId(1)
                .organizationName("wacai")
                .assignCase(true)
                .createTime(new Date())
                .build();
        userService.insert(user);

    }
    @Test
    public void testQueryByAccount(){
        User user = userService.queryByAccount("baota");
        System.err.println(user);

    }


    @Test
    public void myTest() {
        System.err.print(aa);

    }
}
