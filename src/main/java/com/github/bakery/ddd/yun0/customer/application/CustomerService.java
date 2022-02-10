package com.github.bakery.ddd.yun0.customer.application;

import com.github.bakery.ddd.yun0.customer.domain.customer.Customer;
import com.github.bakery.ddd.yun0.customer.domain.customer.CustomerRepository;
import com.github.bakery.ddd.yun0.customer.domain.order.Order;
import com.github.bakery.ddd.yun0.bread.domain.bread.Bread;
import com.github.bakery.ddd.yun0.bread.domain.bread.BreadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final BreadRepository breadRepository;

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 고객입니다."));
    }

    @Transactional
    public List<Bread> order(Order order) {
        var customer = getCustomer(order.getCustomerId());
        var breads = customer.order(order, breadRepository::findAllByTypeAndStatusOrderByProcessedDateTime);
        customerRepository.save(customer);
        breadRepository.saveAll(breads);
        return breads;
    }
}
