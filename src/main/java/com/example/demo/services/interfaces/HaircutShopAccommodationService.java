package com.example.demo.services.interfaces;

import com.example.demo.dto.HaircutShopAccommodation;

import java.util.List;

public interface HaircutShopAccommodationService {

    HaircutShopAccommodation createHaircutShopAccommodation(HaircutShopAccommodation haircutShopAccommodation);

    void updateHaircutShopAccommodationName(String accommodationName, Integer haircutShopAccommodationId);

    List<HaircutShopAccommodation> fetchAllHaircutShopAccommodationByHaircutShopId(Integer haircutShopId);

}
