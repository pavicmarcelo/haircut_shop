package com.example.demo;

import com.example.demo.dto.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    UserServiceImpl userService;


    Users users;

    @Autowired
    UserRepository userRepository;

    @Test
    public void userCreateServiceTest() {

        Users newUser = new Users();

        newUser.setName("MarceloTest");
        newUser.setEmail("marcelo@email.com");
        newUser.setPhoneNumber("09586525258");
        newUser.setPassword("sifra");

        Users checkUserCreation = userService.createUser(newUser);

        Assert.assertNotNull(checkUserCreation);

    }


    @Test
    public void userUpdatePasswordTest() {

        String userOldDbPassword = userService.fetchUserByUserId(3).getPassword();

        String expectedNewPassword = "newPassword";

        userService.updateUsersPassword(3, expectedNewPassword);

        Assert.assertNotEquals(userOldDbPassword, expectedNewPassword);

    }


    @Test
    public void fetchUserByIdTest() {

        Integer testUserId = 1;

        Assert.assertNotNull(userService.fetchUserByUserId(testUserId));

    }

    @Test(expected = UsernameNotFoundException.class)
    public void deleteUserByIdTest() {

        Object object = new UsernameNotFoundException("There is no user with that Id number.");

        userService.deleteUserByUserId(5);

        Assert.assertEquals(object, userService.fetchUserByUserId(5));

    }


    @Test
    public void userUpdateEmailTest() {

        String newUserEmail = "ovoJeNoviEMAIL@EMAIL.com";

        userService.updateUserEmail(3, newUserEmail);

        String updatedUserEmail = userService.fetchUserByUserId(3).getEmail();

        Assert.assertEquals(newUserEmail, updatedUserEmail);

    }


    @Test
    public void userUpdatePhoneNumberTest() {

        String newPhoneNumber = "000-666-999";

        userService.updateUserPhoneNumber(3, newPhoneNumber);

        String updatedUserPhoneNumber = userService.fetchUserByUserId(3).getPhoneNumber();

        Assert.assertEquals(updatedUserPhoneNumber, newPhoneNumber);
    }


    @Test
    public void fetchUserByPhoneNumberTest() {
        String usersPhoneNumber = "85473333";

        Users userFetchedByPhoneNumber = userService.fetchUserByPhoneNumber(usersPhoneNumber);

        Assert.assertEquals(usersPhoneNumber, userFetchedByPhoneNumber.getPhoneNumber());
    }

    @Test(expected = UsernameNotFoundException.class)
    public void userByPhoneNumberDoesNotExist(){

        String falseUserNumber = "7777";

        Exception exception = new UsernameNotFoundException("There is no user with this " + falseUserNumber + " phone number.");

        Users userNotFound = userService.fetchUserByPhoneNumber(falseUserNumber);

        Assert.assertEquals(exception, userNotFound);

    }


    @Test
    public void fetchUserByName() {

        String name = "Jurica";

        List<Users> fetchedUsersByName = userService.fetchUserByName(name);

        for(Users users : fetchedUsersByName){

            Assert.assertEquals(name, users.getName());
        }

    }

    @Test
    public void fetchAllUsersTest() {

        List<Users> fetchAllUsers = userService.findAllUsers();

        Assert.assertNotNull(fetchAllUsers);

    }

}




