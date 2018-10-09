package com.together.learning.thymeleaf.entity;

import java.util.Calendar;

/**
 * @author jiangjian
 */
public class Customer {
    private Integer id;
    private String name;
    private Calendar customerSince;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getCustomerSince() {
        return customerSince;
    }

    public void setCustomerSince(Calendar customerSince) {
        this.customerSince = customerSince;
    }
}
