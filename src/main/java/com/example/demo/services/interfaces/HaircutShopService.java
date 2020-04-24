package com.example.demo.services.interfaces;

import com.example.demo.dto.HaircutShop;

import java.text.ParseException;
import java.util.List;




public interface HaircutShopService {

    void createHaircutShop(HaircutShop haircutShop);

    void deleteHaircutShop(Integer haircutShopId);

    void updatePhoneNumber(Integer haircutShopId, String phoneNumber);

    void updateEmail(Integer haircutShopId, String email);

    void updateAddress(Integer haircutShopId, String address);

    void updatePassword(Integer haircutShopId, String password);

    HaircutShop fetchHaircutShopByHaircutShopId(Integer haircutShopId);

    List<HaircutShop> fetchHaircutShopByName(String haircutShopName);

    List<HaircutShop> fetchAllCurrentWorkingHaircutShop();

    List<HaircutShop> fetchHaircutShopByPrice(Double price);

    // List<HaircutShop> getAllCurrentWorkingHaircutShops(long checkHours);

    // List<HaircutShop> fetchAllHaircutShop();

}
