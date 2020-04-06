package com.example.demo.services.impl;

import com.example.demo.dto.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.interfaces.UserService;
import liquibase.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.constraints.Null;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    Users users;


    @Override
    public void saveUser(Users users) {

        createUser(users);
    }

    @Override
    public void updateEmail(Integer userId, String email) {

    }

    @Override
    public void updateUsersPassword(Integer userId, String password) {

        if (password != null) {

            userRepository.updateUserPassword(passHashed(password), userId);
        }

    }

    @Override
    public Users fetchUserByUserId(Integer userId) {

        if (userId != null) {

            Users listOfAllUsersByUserId = userRepository.findUserByUserId(userId);

            return listOfAllUsersByUserId;
        }
        return null;
    }

    @Override
    public List<Users> fetchUserByName(String name) {

        if (userRepository.findUsersByName(name) != null) {

            List<Users> usersFetchedByName = userRepository.findUsersByName(name);

            return usersFetchedByName;
        }

        return null;
    }


    @Override
    public void deleteUserByUserId(Integer userId) {

        userRepository.deleteUsersByUserId(userId);

    }

    @Override
    public void updateUserPhoneNumber(Users users) {

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
    public List<Users> fetchAllUsers() {

        if (StringUtils.isEmpty(users.getName()) || StringUtils.isEmpty(users.getEmail())) {

            return userRepository.findAll();

        }

        if (StringUtils.isNotEmpty(users.getName())) {


            return userRepository.findUsersByName(users.getName());
        }

        if (StringUtils.isNotEmpty(users.getEmail())) {


            return userRepository.findUsersByEmail(users.getEmail());
        }

        return null;
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