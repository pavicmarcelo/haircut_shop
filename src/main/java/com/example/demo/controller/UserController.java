package com.example.demo.controller;

import com.example.demo.dto.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.interfaces.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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


    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public void deleteUserById(
            @PathVariable(value = "id") final Integer userId) {

        userService.deleteUserByUserId(userId);

    }

    @RequestMapping(value = "/users/{id}/password/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    void updateUserPassword(@PathVariable(value = "id") Integer userId, @RequestBody Users users) {

        userService.updateUsersPassword(userId, users.getPassword());

    }


    @RequestMapping(value = "/users/{id}/email/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    void updateUserEmail(
            @PathVariable(value = "id") final Integer userId, @RequestBody String email) {

        userService.updateUserEmail(userId, email);
    }

    @RequestMapping(value = "/users/{id}/phoneNumber/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    void updateUserPhoneNumber(
            @PathVariable(value = "id") final Integer userId, @RequestBody  Users users ) {

        userRepository.updateUserPhoneNumber(userId,users.getPhoneNumber());

    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Users getUserById(
            @PathVariable(value = "id") final Integer userId) {

        return userService.fetchUserByUserId(userId);
    }


    @RequestMapping(value = "/users-info", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Users> getUsers(@RequestParam(required = false, name = "name") String name, @RequestParam(required = false, name = "email") String email) {

        return userService.fetchUsersInfo(name, email);

    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Users> findAllUsers() {

        return userService.findAllUsers();
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")

    public @ResponseBody
    Users creatingUser(@RequestBody Users users) {

        return userService.createUser(users);
    }

    @RequestMapping(value = "/users/name/{name}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Users> getUsersByName(
            @PathVariable(value = "name") final String name) throws Throwable {

        return userService.fetchUserByName(name);
    }

    @RequestMapping(value = "/users/phoneNumber/{phoneNumber}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Users getUserByPhoneNumber(
            @PathVariable(value = "phoneNumber") final String phoneNumber) throws Throwable {

        return userService.fetchUserByPhoneNumber(phoneNumber);
    }

}
