package com.example.demo.services.impl;

import com.example.demo.dto.HaircutShopAccommodation;
import com.example.demo.repository.HaircutShopAccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HaircutShopAccommodationServiceImpl {

    @Autowired
    HaircutShopAccommodationRepository haircutShopAccommodationRepository;

    HaircutShopAccommodation haircutShopAccommodation;

    public HaircutShopAccommodation createHaircutShopAccommodation(HaircutShopAccommodation haircutShopAccommodation) {

        return haircutShopAccommodationRepository.save(haircutShopAccommodation);

    }

    public void updateHaircutShopAccommodationServicesName(String haircutShopAccommodation, Integer haircutShopAccommodationId) {

        if (!haircutShopAccommodation.isEmpty() && haircutShopAccommodationId != null) {

            haircutShopAccommodationRepository.updateHaircutShopAccommodationName(haircutShopAccommodationId, haircutShopAccommodation);
        }
    }

    public List<HaircutShopAccommodation> fetchAllHaircutShopAccommodationByHaircutShopId(Integer haircutShopId) {

        List<HaircutShopAccommodation> listOfAllAccommodations = haircutShopAccommodationRepository.findHaircutShopAccommodationByHaircutShopId(haircutShopId);

        return listOfAllAccommodations;
    }

    public List<HaircutShopAccommodation> fetchAllHaircutShopAccommodationByPriceRange(Double priceStarting, Double priceEnding) {

        List<HaircutShopAccommodation> listOfAllAccommodation = haircutShopAccommodationRepository.findHaircutShopAccommodationByPriceBetween(priceStarting, priceEnding);

        return listOfAllAccommodation;
//        if(priceEnding != null && priceStarting != null) {
//            for()
//        }

    }

}
