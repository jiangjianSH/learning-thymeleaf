package com.together.learning.thymeleaf.entity;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jiangjian
 */
public class Order {
    private Integer id;
    private Calendar date;
    private Customer customer;
    private Set<OrderLine> orderLines = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Set<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
