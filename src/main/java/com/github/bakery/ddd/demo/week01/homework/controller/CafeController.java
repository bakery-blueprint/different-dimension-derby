package com.github.bakery.ddd.demo.week01.homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bakery.ddd.demo.week01.homework.dto.CreateBreadRequest;
import com.github.bakery.ddd.demo.week01.homework.mapper.CreateBreadMapper;
import com.github.bakery.ddd.demo.week01.homework.service.CafeService;
import com.github.bakery.ddd.demo.week01.homework.vo.CreateBread;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/cafe")
public class CafeController {

    private final CafeService cafeService;
    private final ObjectMapper objectMapper;

    @PostMapping("/breads")
    public String createBread(@RequestBody CreateBreadRequest createBreadRequest) throws JsonProcessingException {
        CreateBread createBread = CreateBreadMapper.toVo(createBreadRequest);
        return objectMapper.writeValueAsString(cafeService.addBreads(createBread));
    }
}
