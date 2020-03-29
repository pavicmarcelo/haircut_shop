package com.example.demo.repository;

import com.example.demo.dto.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface UserRepository extends JpaRepository <Users,Integer> {

    /*
    @Query("UPDATE User u set u.password = :password WHERE u.userId = :customerId")
    int updateUserPassword(@Param("customerId") Integer customerId, @Param("password") String password);
*/

    Users findUserByUserId(Integer userId);

    List <Users> findUsersByName (String name);

    void deleteUsersByUserId(Integer userId);

    String findUsersByPhoneNumber(String phoneNumber);

    List<Users> findUsersByEmail (String email);

}
