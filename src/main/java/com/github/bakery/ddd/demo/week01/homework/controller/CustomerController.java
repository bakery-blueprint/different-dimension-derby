package com.github.bakery.ddd.demo.week01.homework.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bakery.ddd.demo.week01.homework.service.CafeService;
import com.github.bakery.ddd.demo.week01.homework.vo.BuyBread;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/customer")
//@Controller
public class CustomerController {

    private final CafeService cafeService;
    private final ObjectMapper objectMapper;

    @PostMapping("breads")
    public String buyBread(@RequestBody BuyBread buyBread) throws JsonProcessingException {

        return objectMapper.writeValueAsString(cafeService.buyBread(buyBread));
    }
}
