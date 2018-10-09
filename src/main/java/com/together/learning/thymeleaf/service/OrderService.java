package com.together.learning.thymeleaf.service;

import com.together.learning.thymeleaf.dao.OrderRepository;
import com.together.learning.thymeleaf.entity.Order;

import java.util.List;

/**
 * @author jiangjian
 */
public class OrderService {

    public OrderService() {
        super();
    }



    public List<Order> findAll() {
        return OrderRepository.getInstance().findAll();
    }

    public Order findById(final Integer id) {
        return OrderRepository.getInstance().findById(id);
    }

    public List<Order> findByCustomerId(final Integer customerId) {
        return OrderRepository.getInstance().findByCustomerId(customerId);
    }
}
