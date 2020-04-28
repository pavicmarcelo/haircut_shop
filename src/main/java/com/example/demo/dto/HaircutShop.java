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
    @Column(name = "haircut_shop_name")
    String haircutShopName;
    @Column(name = "haircut_shop_address")
    String haircutShopAddress;
    @Column(name = "haircut_shop_phone_number")
    String haircutShopPhoneNumber;
    @Column(name = "haircut_shop_email")
    String haircutShopEmail;
    @Column(name = "start_work_time")
    int startWorkTime;
    @Column(name = "end_work_time")
    int endWorkTime;
    @Column(name = "haircut_shop_description_prices")
    String haircutShopDescriptionPrices;
    @Column(name = "haircut_shop_password")
    String haircutShopPassword;

}
