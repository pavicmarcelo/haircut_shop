package com.example.demo.controller;

import com.example.demo.dto.HaircutShopAccommodation;
import com.example.demo.repository.HaircutShopAccommodationRepository;
import com.example.demo.services.impl.HaircutShopAccommodationServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@Slf4j
public class HaircutShopAccommodationController {

    @Autowired
    HaircutShopAccommodationRepository haircutShopAccommodationRepository;

    @Autowired
    HaircutShopAccommodationServiceImpl haircutShopAccommodationService;


    @RequestMapping(value = "/create-haircut-shop-accommodation", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    HaircutShopAccommodation createHaircutShopAccommodation(@RequestBody HaircutShopAccommodation haircutShopAccommodation) {

        return haircutShopAccommodationService.createHaircutShopAccommodation(haircutShopAccommodation);
    }

    @RequestMapping(value = "/haircutShopAccommodation/{haircutShopAccommodationId}/updateAccommodationName", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    void updateHaircutShopAccommodationName(@PathVariable(value = "haircutShopAccommodationId") Integer haircutShopAccommodationId, @RequestBody String accommodationName) {

        haircutShopAccommodationService.updateHaircutShopAccommodationServicesName(accommodationName, haircutShopAccommodationId);
    }

    @RequestMapping(value = "/haircutShopAccommodation/{haircutShopId}/listAllAccommodation", method = RequestMethod.GET, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    List<HaircutShopAccommodation> findHaircutShopAccommodationByHaircutShopId(@PathVariable(value = "haircutShopId") Integer haircutShopId){
        return haircutShopAccommodationService.fetchAllHaircutShopAccommodationByHaircutShopId(haircutShopId);
    }

    @RequestMapping(value = "/haircutShopAccommodation/{priceStarting}/{priceEnding}/listAllAccommodationInPriceRange", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<HaircutShopAccommodation> findHaircutShopAccommodationByPriceRange(@PathVariable(value = "priceStarting") Double priceStarting, @PathVariable(value = "priceEnding") Double priceEnding) {
        return haircutShopAccommodationService.fetchAllHaircutShopAccommodationByPriceRange(priceStarting, priceEnding);
    }

}
