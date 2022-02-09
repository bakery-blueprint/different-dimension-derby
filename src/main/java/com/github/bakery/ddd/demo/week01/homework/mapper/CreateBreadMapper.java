package com.github.bakery.ddd.demo.week01.homework.mapper;

import com.github.bakery.ddd.demo.week01.homework.dto.CreateBreadRequest;
import com.github.bakery.ddd.demo.week01.homework.vo.CreateBread;

public class CreateBreadMapper {

    public static CreateBread toVo(CreateBreadRequest createBreadRequest) {
        return new CreateBread(createBreadRequest.getCafeId(), createBreadRequest.getBreadName(), createBreadRequest.getAmount());
    }
}
