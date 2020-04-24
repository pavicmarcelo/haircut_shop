package com.example.demo;

import com.example.demo.dto.HaircutShop;
import com.example.demo.repository.HaircutShopRepository;
import com.example.demo.services.interfaces.HaircutShopService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HaircutShopServiceTest {

    @Autowired
    HaircutShopRepository haircutShopRepository;

    @Autowired
    HaircutShopService haircutShopService;

    HaircutShop haircutShop;


    @Test
    public void fetchAllHaircutShopTest() {

        List<HaircutShop> fetchAllHaircutShop = haircutShopRepository.findAll();
        Assert.assertNotNull(fetchAllHaircutShop);
    }


    @Test
    public void createHaircutShopTest() {

        DateTimeFormatter dateTimeFormatter;


        HaircutShop haircutShop = new HaircutShop();
        haircutShop.setHaircutShopName("ImeSalona");
        haircutShop.setHaircutShopAddress("adresa shopa 2");
        haircutShop.setHaircutShopPhoneNumber("097748235");
        haircutShop.setHaircutShopEmail("emaishop@shopovi.fom");
        haircutShop.setHaircutShopPrices("500.00");
        haircutShop.setHaircutShopPassword("sifra3");

        HaircutShop haircutShopSaved = haircutShopRepository.save(haircutShop);

        Assert.assertNotNull(haircutShopSaved);

    }


    // fetchHCSbyName
    // preko servisa dobavimo listu
    // provjeriti preko imena da li je ok
    @Test
    public void fetchHaircutShopByNameTest() {

        String expName = "ImeSalona";

        List<HaircutShop> haircutShopsByName = haircutShopService.fetchHaircutShopByName(expName);

        for(HaircutShop haircutShop : haircutShopsByName) {

            String nameFromDb =  haircutShop.getHaircutShopName();

            Assert.assertEquals(expName, nameFromDb);
        }
    }


    @Test
    public void fetchCurrentWorkingHaircutShopTest() {

        int currentHourForTest = 12;

        List<HaircutShop> getList = new ArrayList<>();

        for (HaircutShop haircutShop : haircutShopRepository.findAll()) {

            if (currentHourForTest < haircutShop.getEndWorkTime() && currentHourForTest >= haircutShop.getStartWorkTime()) {

                getList.add(haircutShop);

            }

        }
        Assert.assertNotNull(getList);
    }




}
