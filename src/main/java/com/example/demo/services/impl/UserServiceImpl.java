package com.example.demo.services.impl;

import com.example.demo.dto.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.interfaces.UserService;
import liquibase.util.StringUtils;
import org.dom4j.dom.DOMNodeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.transaction.Transactional;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public void updateUserEmail(Integer userId, String email) {

        if (email != null) {
            userRepository.updateUserEmail(userId, email);
        }

    }

    @Override
    public void updateUsersPassword(Integer userId, String password) {

        if (password != null) {

            userRepository.updateUserPassword(passHashed(password), userId);
        }
    }

    @Override
    public void updateUserPhoneNumber(Integer userId, String phoneNumber) {
        if (phoneNumber != null) {
            userRepository.updateUserPhoneNumber(userId, phoneNumber);
        }
    }

    @Override
    public Users fetchUserByUserId(Integer userId) {

        Users listOfAllUsersByUserId = userRepository.findUserByUserId(userId);

        if (listOfAllUsersByUserId != null) {

            return listOfAllUsersByUserId;

        } else {
            throw new UsernameNotFoundException("There is no user with that Id number.");
        }
    }

    @Override
    public List<Users> fetchUserByName(String name) {

        List<Users> listOfUsers = userRepository.findUsersByName(name);

        if (listOfUsers.isEmpty()) {

            throw new UsernameNotFoundException("There is no user with this " + name + " name.");
        }
        return listOfUsers;
    }


    @Override
    public void deleteUserByUserId(Integer userId) {


        userRepository.deleteById(userId);

    }

    @Override
    public Users fetchUserByPhoneNumber(String phoneNumber) {

        Users fetchedUserByPhoneNumber = userRepository.findUsersByPhoneNumber(phoneNumber);

        if (fetchedUserByPhoneNumber != null) {

            return fetchedUserByPhoneNumber;

        } else {

            throw new UsernameNotFoundException("There is no user with this " + phoneNumber + " phone number.");
        }
    }


    @Override
    public List<Users> fetchUsersInfo(String name, String email) {

        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(email)) {

            return userRepository.findAll();

        }

        if (StringUtils.isNotEmpty(name)) {

            return userRepository.findUsersByName(name);
        }

        if (StringUtils.isNotEmpty(email)) {

            return userRepository.findUsersByEmail(email);
        }

        return null;
    }

    @Override
    public List<Users> findAllUsers() {
        List<Users> allUsers = userRepository.findAll();
        return allUsers;
    }

    @Override
    public Users createUser(Users users) {

        users.setPassword(passHashed(users.getPassword()));

        return userRepository.save(users);
    }

    private String passHashed(String password) {

        return passwordEncoder.encode(password);
    }
}