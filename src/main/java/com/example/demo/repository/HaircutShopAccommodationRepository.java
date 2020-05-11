package com.example.demo.repository;

import com.example.demo.dto.HaircutShopAccommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface HaircutShopAccommodationRepository extends JpaRepository<HaircutShopAccommodation, Integer> {


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE HaircutShopAccommodation hs set hs.accommodationName = :accommodationName WHERE hs.haircutShopAccommodationId = :haircutShopAccommodationId")
    int updateHaircutShopAccommodationName(@Param("haircutShopAccommodationId") Integer haircutShopAccommodationId, @Param("accommodationName") String accommodationName);

}