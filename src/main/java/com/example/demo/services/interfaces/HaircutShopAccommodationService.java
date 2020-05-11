package com.example.demo.services.interfaces;

import com.example.demo.dto.HaircutShopAccommodation;

public interface HaircutShopAccommodationService {

    HaircutShopAccommodation createHaircutShopAccommodation(HaircutShopAccommodation haircutShopAccommodation);

    void updateHaircutShopAccommodationName(String accommodationName, Integer haircutShopAccommodationId);

}
