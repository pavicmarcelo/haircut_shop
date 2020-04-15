package com.example.demo.services.interfaces;

import com.example.demo.dto.HaircutShop;

import java.util.List;


public interface HaircutShopService {

    void createNewHaircutShop(HaircutShop haircutShop);

    void deleteHaircutShop(Integer haircutShopId);

    void updatePhoneNumber(Integer haircutShopId, String phoneNumber);

    void updateEmail(Integer haircutShopId, String email);

    void updateAddress(Integer haircutShopId, String address);

    void updatePassword(Integer haircutShopId, String password);

    HaircutShop fetchHaircutShopByHaircutShopId(Integer haircutShopId);

    List<HaircutShop> fetchHaircutShopByName(String haircutShopName);

    List<HaircutShop> fetchHaircutShopByWorkTime(String workTime);

    List<HaircutShop> fetchHaircutShopByPrice(Double price);

    List<HaircutShop> fetchAllHaircutShop();

}
