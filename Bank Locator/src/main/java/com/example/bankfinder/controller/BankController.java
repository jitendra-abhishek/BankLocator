package com.example.bankfinder.controller;

import com.example.bankfinder.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping("/api/banks")
    public List<Map<String, Object>> getNearbyBanks(@RequestParam String zipcode) {
        return bankService.findNearbyBanks(zipcode);
    }
}