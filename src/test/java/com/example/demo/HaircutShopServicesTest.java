package com.example.demo;

import com.example.demo.dto.HaircutShopServices;
import com.example.demo.repository.HaircutShopServicesRepository;
import com.example.demo.services.impl.HaircutShopServicesServiceImpl;
import com.example.demo.services.interfaces.HaircutShopService;
import com.example.demo.services.interfaces.HaircutShopServicesService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HaircutShopServicesTest {

    @Autowired
    HaircutShopServicesRepository haircutShopServicesRepository;

    @Autowired
    HaircutShopServicesServiceImpl haircutShopServicesService;

    @Test
    public void createHaircutShopServicesTest() {
        HaircutShopServices haircutShopServices = new HaircutShopServices();

        haircutShopServices.setServicesName("Zensko sisanje");
        haircutShopServices.setPrice(400.00);
        haircutShopServices.setDescription("amerika");
        haircutShopServices.setHaircutShopId(2);

        HaircutShopServices createdHaircutShopServices = haircutShopServicesService.createHaircutShopServices(haircutShopServices);

        Assert.assertNotNull(createdHaircutShopServices);

    }

}
