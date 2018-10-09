package com.together.learning.thymeleaf.service;

/**
 * @author jiangjian
 */
import java.util.List;

import com.together.learning.thymeleaf.dao.CustomerRepository;
import com.together.learning.thymeleaf.entity.Customer;

public class CustomerService {



    public CustomerService() {
        super();
    }



    public List<Customer> findAll() {
        return CustomerRepository.getInstance().findAll();
    }

    public Customer findById(final Integer id) {
        return CustomerRepository.getInstance().findById(id);
    }

}