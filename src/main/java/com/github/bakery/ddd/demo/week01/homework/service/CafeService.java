package com.github.bakery.ddd.demo.week01.homework.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.github.bakery.ddd.demo.week01.homework.domain.baking.Baking;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.Bread;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.factory.BakingFactory;
import com.github.bakery.ddd.demo.week01.homework.domain.cafe.Bag;
import com.github.bakery.ddd.demo.week01.homework.domain.cafe.Cafe;
import com.github.bakery.ddd.demo.week01.homework.domain.cafe.repository.CafeRepository;
import com.github.bakery.ddd.demo.week01.homework.domain.customer.Customer;
import com.github.bakery.ddd.demo.week01.homework.domain.customer.repository.CustomerRepository;
import com.github.bakery.ddd.demo.week01.homework.vo.BuyBread;
import com.github.bakery.ddd.demo.week01.homework.vo.CreateBread;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CafeService {

    private final CafeRepository cafeRepository;

    private final CustomerRepository customerRepository;

    @Transactional
    public Bag buyBread(BuyBread buyBread) {
        Customer customer = customerRepository.findById(buyBread.getCustomerId())
                                              .orElseThrow(() -> new IllegalArgumentException("Customer does not exist."));

        Cafe cafe = cafeRepository.findById(buyBread.getCafeId())
                                  .orElseThrow(() -> new IllegalArgumentException("This cafe doesn't exist."));

        int breadPrice = cafe.getBreadPrice(buyBread.getBreadName());
        Integer money = customer.payForBread(breadPrice, buyBread.getAmount());
        Bag bag = cafe.buyBread(buyBread.getBreadName(), money, buyBread.getAmount());
        customer.addBread(bag.getBreads());
        return bag;
    }

    @Transactional
    public CreateBread addBreads(CreateBread createBread) {

        Baking baking = BakingFactory.createBaking(createBread.getBreadName());

        List<Bread> breads = new ArrayList<>();
        for (int i = 0; i < createBread.getAmount(); i++) {
            breads.add(baking.createBread());
        }
        Cafe cafe = cafeRepository.findById(createBread.getCafeId())
                                  .orElseThrow(() -> new IllegalArgumentException("This cafe doesn't exist."));

        cafe.addBreadStock(breads);

        return new CreateBread(createBread.getCafeId(), createBread.getBreadName(), cafe.getBreads().size());
    }
}