package com.example.demo;

import com.example.demo.dto.Users;
import com.example.demo.services.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    public void userCreateServiceTest(){

        Users newUser = new Users();

        newUser.setName("MarceloTest");
        newUser.setEmail("marcelo@email.com");
        newUser.setPhoneNumber("09586525258");
        newUser.setPassword("sifra");

        Users checkUserCreation = userService.createUser(newUser);

        Assert.assertNotNull(checkUserCreation);

    }
}
