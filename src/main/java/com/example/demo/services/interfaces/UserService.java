package com.example.demo.services.interfaces;

import com.example.demo.dto.Users;


import java.util.List;

public interface UserService {


    void saveUser(Users users);

    Users fetchUserByUserId(Integer userId);

    List<Users> fetchUserByName(String name);

    Users createUser(Users users);

    void deleteUserByUserId(Integer userId);

    void updateUserPhoneNumber(Users users);

    String fetchUserByPhoneNumber(Users users);

    void updateEmail(Integer userId, String email);

    void updateUsersPassword(Integer userId, String password);

    List<Users> fetchUserInfo();

}
