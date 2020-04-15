package com.example.demo.services.interfaces;

import com.example.demo.dto.Users;

import java.util.List;

public interface UserService {

    void deleteUserByUserId(Integer userId);

    void updateUserEmail(Integer userId, String email);

    void updateUsersPassword(Integer userId, String password);

    void updateUserPhoneNumber(Integer userId, String phoneNumber);

    Users fetchUserByPhoneNumber(String phoneNumber);

    Users fetchUserByUserId(Integer userId);

    Users createUser(Users users);

    List<Users> fetchUsersInfo(String name, String email);

    List<Users> findAllUsers();

    List<Users> fetchUserByName(String name);

}
