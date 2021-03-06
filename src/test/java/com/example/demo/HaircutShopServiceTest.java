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

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


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

        HaircutShop haircutShopNew = new HaircutShop();

        haircutShopNew.setName("ImeSalona");
        haircutShopNew.setAddress("adresa shopa 2");
        haircutShopNew.setPhoneNumber("097748235");
        haircutShopNew.setEmail("emaishop@shopovi.fom");
        haircutShopNew.setDescriptionPrices("500.00");
        haircutShopNew.setPassword("sifra3");

        HaircutShop haircutShopSaved = haircutShopRepository.save(haircutShopNew);

        Assert.assertNotNull(haircutShopSaved);

    }


    @Test
    public void fetchHaircutShopByNameTest() {

        String expName = "ImeSalona";

        List<HaircutShop> haircutShopsByName = haircutShopService.fetchHaircutShopByName(expName);

        for (HaircutShop haircutShop : haircutShopsByName) {

            String nameFromDb = haircutShop.getName();

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


    @Test
    public void deleteHaircutShopByIdTest() {

        int haircutShopId = 10;

        if (haircutShopService.fetchHaircutShopByHaircutShopId(haircutShopId) == null) {
            throw new NoSuchElementException();
        }

        haircutShopService.deleteHaircutShopById(haircutShopId);

        Assert.assertSame(null, haircutShopService.fetchHaircutShopByHaircutShopId(haircutShopId));

    }


    @Test
    public void checkGettingHaircutShopByID() {

        HaircutShop shops = haircutShopRepository.findHaircutShopByHaircutShopId(5);

        Assert.assertEquals(null, shops);

    }


    @Test
    public void fetchHaircutShopsByDescriptionPriceTest() {
        String descriptionPrice = "LOW";

        List<HaircutShop> haircutShopsByDescriptionPrice = haircutShopService.fetchHaircutShopByDescriptionPrice(descriptionPrice);

        for (HaircutShop haircutShop : haircutShopsByDescriptionPrice) {

            String descriptionPriceFromDB = haircutShop.getDescriptionPrices();

            Assert.assertEquals(descriptionPrice, descriptionPriceFromDB);
        }
    }

}
