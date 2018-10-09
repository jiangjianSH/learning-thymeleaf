package com.together.learning.thymeleaf.service;

import com.together.learning.thymeleaf.dao.ProductRepository;
import com.together.learning.thymeleaf.entity.Product;

import java.util.List;

/**
 * @author jiangjian
 */
public class ProductService {

    public ProductService() {
        super();
    }



    public List<Product> findAll() {
        return ProductRepository.getInstance().findAll();
    }

    public Product findById(final Integer id) {
        return ProductRepository.getInstance().findById(id);
    }
}
