package com.example.demo.controllers;

import com.example.demo.models.Order;
import com.example.demo.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class ApiController {

    @Autowired
    PriceService priceService;

    @PostMapping("/orderprice")
    @ResponseBody
    public Map<String, String> createPick(@RequestBody List<Order> orders) {
        return priceService.calculatePrice(orders);
    }
}
