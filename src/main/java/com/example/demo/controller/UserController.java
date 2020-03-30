package com.example.demo.controller;

import com.example.demo.dto.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.interfaces.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Validated
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")

    public Users getUserById(
            @PathVariable(value = "id") final Integer userId) {

        return userService.fetchUserByUserId(userId);
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Users> getAllUsers() {

        return  userRepository.findAll();

    }

    @RequestMapping(value = "/create-user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")

    public @ResponseBody
    Users creatingUser(@RequestBody Users users) {

        return userService.createUser(users);
    }



/*
    @RequestMapping(value = "/create-user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    User creatingUser(@RequestBody User userPassword) {

        return userService.createUser(userPassword);

    }


    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")

    public void deleteUserById(
            @PathVariable(value = "id") final Integer userId) {

    }



    @RequestMapping(value = "/users/{users}", method = RequestMethod.PUT, produces = "applicaton/json;charset=UTF-8")
    public void updateUserPhoneNumber(
            @PathVariable(value = "users") final Users users) {
              userService.updateUserPhoneNumber(users);
    }


    @RequestMapping(value = "/users/{id}/mail/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    void updateUserEmail(
            @PathVariable(value = "id") final Integer userId, @RequestBody String email) {

        userService.updateEmail(userId, email);
    }


    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public void updateUserPassword(
            @PathVariable(value = "id") final Integer userId, String password) {
        userService.updatePassword(userId, password);
    }
*/

}
