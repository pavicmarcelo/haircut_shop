package com.example.demo.services.impl;

import com.example.demo.dto.HaircutShop;
import com.example.demo.repository.HaircutShopRepository;
import com.example.demo.services.interfaces.HaircutShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class HaircutShopServiceImpl implements HaircutShopService {

    @Autowired
    HaircutShopRepository haircutShopRepository;


    @Override
    public void createNewHaircutShop(HaircutShop haircutShop) {

        haircutShopRepository.save(haircutShop);

    }

    @Override
    public void deleteHaircutShop(Integer haircutShopId) {

        haircutShopRepository.deleteHaircutShopByHaircutShopId(haircutShopId);

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

        if (haircutShopId != null) {

            HaircutShop fetchedHaircutShopByHaircutShopId = haircutShopRepository.findHaircutShopByHaircutShopId(haircutShopId);

            return fetchedHaircutShopByHaircutShopId;
        }

        return null;

    }

    @Override
    public List<HaircutShop> fetchHaircutShopByName(String haircutShopName) {

        if (haircutShopName != null) {

            List<HaircutShop> fetchedHaircutShopByHaircutShopName = haircutShopRepository.findHaircutShopByHaircutShopName(haircutShopName);

            return fetchedHaircutShopByHaircutShopName;
        }

        return null;
    }


    @Override
    public List<HaircutShop> fetchHaircutShopByWorkTime(String workTime) {

        if (workTime != null) {

            List<HaircutShop> haircutShopFetchedByWorkTime = haircutShopRepository.findHaircutShopByHaircutShopWorkTime(workTime);

            return haircutShopFetchedByWorkTime;
        }

        return null;
    }

    @Override
    public List<HaircutShop> fetchHaircutShopByPrice(Double price) {

        if (price != null) {

            List<HaircutShop> haircutShopFetchedByPrice = haircutShopRepository.findHaircutShopByHaircutShopPrices(price);

            return haircutShopFetchedByPrice;
        }

        return null;
    }


}
