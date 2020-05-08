package com.example.demo.repository;

import com.example.demo.dto.HaircutShop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HaircutShopRepository extends JpaRepository<HaircutShop, Integer> {

    HaircutShop findHaircutShopById(Integer id);

    List<HaircutShop> findHaircutShopByName(String name);

    List<HaircutShop> findHaircutShopByDescriptionPrices(String price);

}