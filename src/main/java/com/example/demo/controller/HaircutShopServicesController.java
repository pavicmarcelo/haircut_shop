package com.example.demo.controller;

import com.example.demo.dto.HaircutShopServices;
import com.example.demo.repository.HaircutShopServicesRepository;
import com.example.demo.services.impl.HaircutShopServicesServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@Slf4j
public class HaircutShopServicesController {

    @Autowired
    HaircutShopServicesRepository haircutShopServicesRepository;

    @Autowired
    HaircutShopServicesServiceImpl haircutShopServicesService;


    @RequestMapping(value = "/create-haircut-shop-services", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    HaircutShopServices createHaircutShopServices(@RequestBody HaircutShopServices haircutShopServices) {

        return haircutShopServicesService.createHaircutShopServices(haircutShopServices);
    }

}
