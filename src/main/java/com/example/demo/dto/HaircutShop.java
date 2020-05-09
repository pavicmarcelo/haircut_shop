package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Table(name = "haircut_shop")
@Data
@Entity
@NotNull
public class HaircutShop {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "haircut_shop_seq")
    @SequenceGenerator(name = "haircut_shop_seq", sequenceName = "seq_haircut_shop", initialValue = 1, allocationSize = 1)
    @Column(name = "haircut_shop_id")
    Integer haircutShopId;
    @Column(name = "start_work_time")
    int startWorkTime;
    @Column(name = "end_work_time")
    int endWorkTime;
    @Column(name = "description_prices")
    String descriptionPrices;
    @Column(name = "phone_number")
    String phoneNumber;
    String name;
    String address;
    String email;
    String password;

}
