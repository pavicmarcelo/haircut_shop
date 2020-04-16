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
public class HaircutShopController {

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

}
