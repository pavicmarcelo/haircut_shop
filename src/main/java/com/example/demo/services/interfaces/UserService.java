package com.example.demo.services.interfaces;

import com.example.demo.dto.Users;

import java.util.List;

public interface UserService {

    void saveUser(Users users);

    void deleteUserByUserId(Integer userId);

    void updateUserPhoneNumber(Users users);

    void updateEmail(Integer userId, String email);

    void updateUsersPassword(Integer userId, String password);

    Users fetchUserByPhoneNumber(String phoneNumber) throws Throwable;

    Users fetchUserByUserId(Integer userId);

    Users createUser(Users users);

    List<Users> fetchUserByName(String name);

    List<Users> fetchAllUsers(String name, String email);

}
