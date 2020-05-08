package com.example.demo.controller;

import com.example.demo.dto.HaircutShop;
import com.example.demo.repository.HaircutShopRepository;
import com.example.demo.services.interfaces.HaircutShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Validated
@Slf4j
public class
HaircutShopController {

    @Autowired
    HaircutShopRepository haircutShopRepository;

    @Autowired
    HaircutShopService haircutShopService;


    @RequestMapping(value = "/haircut-shop", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<HaircutShop> fetchAllHaircutShop() {

        return haircutShopRepository.findAll();
    }


    @RequestMapping(value = "/create-haircut-shop", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    HaircutShop createHaircutShop(@RequestBody HaircutShop haircutShop) {

        return haircutShopRepository.save(haircutShop);
    }


    @RequestMapping(value = "/haircut-shop/name/{name}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<HaircutShop> getHaircutShopByName(
            @PathVariable(value = "name") final String name) {

        return haircutShopService.fetchHaircutShopByName(name);
    }


    @RequestMapping(value = "/haircut-shop/work-time/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<HaircutShop> getHaircutShopByWorkTime() {

        return haircutShopService.fetchAllCurrentWorkingHaircutShop();
    }


    @RequestMapping(value = "/haircut-shop/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public void deleteHaircutShopById(
            @PathVariable(value = "id") final Integer id) {

        haircutShopService.deleteHaircutShopById(id);
    }


    @RequestMapping(value = "/haircut-shop/prices/{price}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<HaircutShop> getHaircutShopByDescriptionPrice(
            @PathVariable(value = "price") String price) {

        return haircutShopService.fetchHaircutShopByDescriptionPrice(price);
    }

}