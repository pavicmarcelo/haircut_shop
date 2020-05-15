package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "haircut_shop_accommodation")
@Data
@Entity
@NotNull
public class HaircutShopAccommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "haircut_shop_accommodation_seq")
    @SequenceGenerator(name = "haircut_shop_accommodation_seq", sequenceName = "seq_haircut_shop_accommodation", initialValue = 1, allocationSize = 1)
    @Column(name = "haircut_shop_accommodation_id")
    Integer haircutShopAccommodationId;
    @Column(name = "accommodation_name")
    String accommodationName;
    Double price;
    String description;
    @Column(name = "haircut_shop_id")
    Integer haircutShopId;


}
