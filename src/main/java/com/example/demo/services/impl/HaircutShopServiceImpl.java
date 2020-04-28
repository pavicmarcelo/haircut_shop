package com.example.demo.services.impl;

import com.example.demo.dto.HaircutShop;
import com.example.demo.repository.HaircutShopRepository;
import com.example.demo.services.interfaces.HaircutShopService;
import com.example.demo.time_services.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class
HaircutShopServiceImpl implements HaircutShopService {

    @Autowired
    HaircutShopRepository haircutShopRepository;

    @Autowired
    LocalTime localTime;


    @Override
    public void createHaircutShop(HaircutShop haircutShop) {

        haircutShopRepository.save(haircutShop);
    }

    @Override
    public void deleteHaircutShopById(Integer haircutShopId) {

        haircutShopRepository.deleteById(haircutShopId);
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

        return haircutShopRepository.findHaircutShopByHaircutShopId(haircutShopId);

    }

    @Override
    public List<HaircutShop> fetchHaircutShopByName(String name) {

        List<HaircutShop> haircutShopFetchedByName = haircutShopRepository.findHaircutShopByHaircutShopName(name);

        if (haircutShopFetchedByName.isEmpty()) {

            throw new UsernameNotFoundException("There is no user with this " + name + " name.");
        }
        return haircutShopFetchedByName;
    }

    @Override
    public List<HaircutShop> fetchAllCurrentWorkingHaircutShop() {

        int currentTime = localTime.getCurrentHours();

        List<HaircutShop> getList = new ArrayList<>();

        for (HaircutShop haircutShop : haircutShopRepository.findAll()) {

            if (currentTime < haircutShop.getEndWorkTime() && currentTime >= haircutShop.getStartWorkTime()) {

                getList.add(haircutShop);

            }
        }
        return getList;
    }


    @Override
    public List<HaircutShop> fetchHaircutShopByDescriptionPrice(String price) {

        if ((price.isEmpty())) {
            throw new UsernameNotFoundException("There is no haircut shops with this price. You can choose between LOW, MEDIUM and HIGH");
        }

        return haircutShopRepository.findHaircutShopByHaircutShopDescriptionPrices(price);

    }


}