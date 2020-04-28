package com.example.demo.repository;

import com.example.demo.dto.HaircutShop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HaircutShopRepository extends JpaRepository<HaircutShop, Integer> {

    HaircutShop findHaircutShopByHaircutShopId(Integer haircutShopId);

    List<HaircutShop> findHaircutShopByHaircutShopName(String haircutShopName);

    List<HaircutShop> findHaircutShopByHaircutShopDescriptionPrices(String price);

}