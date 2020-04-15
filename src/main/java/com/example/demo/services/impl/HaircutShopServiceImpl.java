package com.example.demo.services.impl;

import com.example.demo.dto.HaircutShop;
import com.example.demo.repository.HaircutShopRepository;
import com.example.demo.services.interfaces.HaircutShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class HaircutShopServiceImpl implements HaircutShopService {

    HaircutShopRepository haircutShopRepository;

    @Override
    public List<HaircutShop> fetchAllHaircutShop() {

        List<HaircutShop> haircutShopList = haircutShopRepository.findAll();

        return haircutShopList;
    }

    @Override
    public void createNewHaircutShop(HaircutShop haircutShop) {



    }

    @Override
    public void deleteHaircutShop(Integer haircutShopId) {



    }

    @Override
    public void updatePhoneNumber(Integer haircutShopId, String phoneNumber) {

    }

    @Override
    public void updateEmail(Integer haircutShopId, String email) {


    }

    @Override
    public void updateAddress(Integer haircutShopId, String address) {


    }

    @Override
    public void updatePassword(Integer haircutShopId, String password) {

    }

    @Override
    public HaircutShop fetchHaircutShopByHaircutShopId(Integer haircutShopId) {



        return null;

    }

    @Override
    public List<HaircutShop> fetchHaircutShopByName(String haircutShopName) {



        return null;
    }


    @Override
    public List<HaircutShop> fetchHaircutShopByWorkTime(String workTime) {

     return null;
    }

    @Override
    public List<HaircutShop> fetchHaircutShopByPrice(Double price) {

        return  fetchHaircutShopByPrice(price);
    }


}
