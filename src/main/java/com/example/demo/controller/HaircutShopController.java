package com.example.demo.controller;

import com.example.demo.dto.HaircutShop;
import com.example.demo.repository.HaircutShopRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HaircutShopController {

    HaircutShopRepository haircutShopRepository;

    @RequestMapping(value = "/haircutShop", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<HaircutShop> fetchAllHaircutShop() {

        return haircutShopRepository.findAll();
    }


}
