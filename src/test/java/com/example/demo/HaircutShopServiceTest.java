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

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HaircutShopServiceTest {

    @Autowired
    HaircutShopRepository haircutShopRepository;

    @Autowired
    HaircutShopService haircutShopService;



    @Test
    public void fetchAllHaircutShopTest() {

        List<HaircutShop> fetchAllHaircutShop = haircutShopRepository.findAll();
        Assert.assertNotNull(fetchAllHaircutShop);
    }

    // testiramo create haircut shop-a
    // preko "save" - nalazi se u repu
    // kako to testirati? -
    // zelimo provjeriti da kad smo kreirali objekt da je metoda .save napravila spremanje objekta u bazu
    @Test
    public void createHaircutShopTest() {

        HaircutShop haircutShop = new HaircutShop();
        haircutShop.setHaircutShopName("ImeSalona");
        haircutShop.setHaircutShopAddress("adresa shopa 2");
        haircutShop.setHaircutShopPhoneNumber("097748235");
        haircutShop.setHaircutShopEmail("emaishop@shopovi.fom");
        haircutShop.setHaircutShopWorkTime("zauvik 0-24");
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


}
