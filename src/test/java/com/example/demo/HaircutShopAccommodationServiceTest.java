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

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HaircutShopAccommodationServiceTest {

    @Autowired
    HaircutShopAccommodationRepository haircutShopAccommodationRepository;

    @Autowired
    HaircutShopAccommodationServiceImpl haircutShopAccommodationService;

    HaircutShopAccommodation haircutShopAccommodation;

    @Test
    public void createHaircutShopAccommodationTest() {
        HaircutShopAccommodation haircutShopAccommodation = new HaircutShopAccommodation();

        haircutShopAccommodation.setAccommodationName("Zensko sisanje");
        haircutShopAccommodation.setPrice(400.00);
        haircutShopAccommodation.setDescription("amerika");
        haircutShopAccommodation.setHaircutShopId(2);

        HaircutShopAccommodation createdHaircutShopAccommodation = haircutShopAccommodationService.createHaircutShopAccommodation(haircutShopAccommodation);

        Assert.assertNotNull(createdHaircutShopAccommodation);

    }

    @Test
    public void updateHaircutShopAccommodationNameTest() {

        String newServicesName = "novo ime za sisanje3";

        Integer haircutShopServicesId = 3;

        haircutShopAccommodationService.updateHaircutShopAccommodationServicesName(newServicesName, haircutShopServicesId);

        Assert.assertTrue(newServicesName.isEmpty());

    }

    @Test
    public void fetchAllHaircutShopAccommodationByHaircutShopIdTest() {

        List<HaircutShopAccommodation> listOfAllAccommodationByHaircutShopId = haircutShopAccommodationService.fetchAllHaircutShopAccommodationByHaircutShopId(3);

        Assert.assertTrue(listOfAllAccommodationByHaircutShopId.size() >= 3);

    }

    @Test
    public void fetchHaircutShopAccommodationByPriceRangeTest() {

        List<HaircutShopAccommodation> listOfHaircutShopAccommodation = haircutShopAccommodationService.fetchAllHaircutShopAccommodationByPriceRange(100.0, 500.5);

        Assert.assertTrue(listOfHaircutShopAccommodation.size() == 2);
    }


}
