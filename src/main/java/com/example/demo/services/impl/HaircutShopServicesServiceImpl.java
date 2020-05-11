package com.example.demo.services.impl;

import com.example.demo.dto.HaircutShopServices;
import com.example.demo.repository.HaircutShopServicesRepository;
import com.example.demo.services.interfaces.HaircutShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HaircutShopServicesServiceImpl {

    @Autowired
    HaircutShopServicesRepository haircutShopServicesRepository;

    HaircutShopServices haircutShopServices;

    public HaircutShopServices createHaircutShopServices(HaircutShopServices haircutShopServices){

       return haircutShopServicesRepository.save(haircutShopServices);

    }
}
