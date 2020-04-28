package com.example.demo.repository;

import com.example.demo.dto.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface UserRepository extends JpaRepository<Users, Integer> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Users u set u.password = :password WHERE u.userId = :user_id")
    int updateUserPassword(@Param("password") String password, @Param("user_id") Integer userId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Users u set u.email = :email WHERE u.userId = :user_id")
    void updateUserEmail(@Param("user_id") Integer userId, @Param("email") String email);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Users u set u.phoneNumber = :phoneNumber WHERE u.userId = :user_id")
    void updateUserPhoneNumber(@Param("user_id") Integer userId, @Param("phoneNumber") String phoneNumber);

    Users findUsersByPhoneNumber(String phoneNumber);

    Users findUserByUserId(Integer userId);

    List<Users> findUsersByName(String name);

    List<Users> findUsersByEmail(String email);

}
