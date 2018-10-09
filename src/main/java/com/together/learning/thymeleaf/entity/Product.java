package com.together.learning.thymeleaf.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author jiangjian
 */
public class Product {
    private Integer id;
    private String name;
    private BigDecimal price;
    private boolean inStock;
    private List<Comment> comments = new ArrayList<>();

    public Product(Integer id, String name, BigDecimal price, boolean inStock, List<Comment> comments) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inStock = inStock;
        this.comments = comments;
    }

    public Product(Integer id, String name, boolean inStock, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.inStock = inStock;
        this.price = price;
    }


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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
