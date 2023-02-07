package org.east.laugh.app.service;

import io.github.thundzeng.miniemail.core.MiniEmail;
import io.github.thundzeng.miniemail.core.MiniEmailFactory;
import io.github.thundzeng.miniemail.core.MiniEmailFactoryBuilder;
import org.east.laugh.app.mapper.UserMapper;
import org.east.laugh.app.util.JWTGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserServiceTest(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }


    @Test
    public void test(){
        System.out.println( userMapper.SelectByEmailAndPwd("east_laugh@qq.com","jiaoshe123"));
    }


    @Autowired
    private JWTGenerator jwtGenerator;

    @Test
    public void test2(){
        jwtGenerator.GenerateJwt("email");
    }

    @Test
    public void test3(){
        String str1 = "hello";
        String str2 = "hello";

//使用==比较
        System.out.println(str1 == str2);
    }



    @Test
    public void testSendEmail(){


    }
}
