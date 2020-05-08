package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Data
@Entity
@NotNull
public class Users {

    @Column(name = "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @SequenceGenerator(name = "users_seq", sequenceName = "seq_users", initialValue = 1, allocationSize = 1)
    Integer userId;
    @Column(name = "phone_number")
    String phoneNumber;
    String name;
    String email;
    String password;

}



