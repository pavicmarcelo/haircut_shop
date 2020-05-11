package com.example.demo;

import com.example.demo.dto.HaircutShopAccommodation;
import com.example.demo.repository.HaircutShopAccommodationRepository;
import com.example.demo.services.impl.HaircutShopAccommodationServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HaircutShopAccommodationServiceTest {

    @Autowired
    HaircutShopAccommodationRepository haircutShopAccommodationRepository;

    @Autowired
    HaircutShopAccommodationServiceImpl haircutShopServicesService;

    HaircutShopAccommodation haircutShopAccommodation;

    @Test
    public void createHaircutShopServicesTest() {
        HaircutShopAccommodation haircutShopAccommodation = new HaircutShopAccommodation();

        haircutShopAccommodation.setAccommodationName("Zensko sisanje");
        haircutShopAccommodation.setPrice(400.00);
        haircutShopAccommodation.setDescription("amerika");
        haircutShopAccommodation.setHaircutShopId(2);

        HaircutShopAccommodation createdHaircutShopAccommodation = haircutShopServicesService.createHaircutShopAccommodation(haircutShopAccommodation);

        Assert.assertNotNull(createdHaircutShopAccommodation);

    }

    @Test
    public void updateHaircutShopServicesNameTest() {

        String newServicesName = "novo ime za sisanje3";

        Integer haircutShopServicesId = 3;

        haircutShopServicesService.updateHaircutShopAccommodationServicesName(newServicesName, haircutShopServicesId);

        Assert.assertTrue(newServicesName.isEmpty());

    }

}
