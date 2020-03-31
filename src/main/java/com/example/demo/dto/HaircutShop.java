package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "haircut_shop")
@Data
@Entity
@NotNull
public class HaircutShop {

    @Id
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
    @Column(name = "haircut_shop_work_time")
    String haircutShopWorkTime;
    @Column(name = "haircut_shop_prices")
    String haircutShopPrices;
    @Column(name = "haircut_shop_password")
    String haircutShopPassword;

}
