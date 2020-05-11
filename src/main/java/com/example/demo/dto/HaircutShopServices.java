package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "haircut_shop_services")
@Data
@Entity
@NotNull
public class HaircutShopServices {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "haircut_shop_services_seq")
    @SequenceGenerator(name = "haircut_shop_services_seq", sequenceName = "seq_haircut_shop_services", initialValue = 1, allocationSize = 1)
    @Column(name = "haircut_shop_services_id")
    Integer haircutShopServicesId;
    @Column(name = "services_name")
    String servicesName;
    Double price;
    String description;
    @Column(name = "haircut_shop_id")
    Integer haircutShopId;

}
