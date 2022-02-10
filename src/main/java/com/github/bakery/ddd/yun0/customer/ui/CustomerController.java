package com.github.bakery.ddd.yun0.customer.ui;

import com.github.bakery.ddd.yun0.customer.application.CustomerService;
import com.github.bakery.ddd.yun0.customer.domain.order.Order;
import com.github.bakery.ddd.yun0.bread.domain.bread.Bread;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/customers")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<List<Bread>> order(Order order) {
        return ResponseEntity.ok(customerService.order(order));
    }
}
