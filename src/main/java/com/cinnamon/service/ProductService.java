package com.cinnamon.service;

import com.cinnamon.model.Product;

import java.util.List;

public interface ProductService {
    Product persist(Product product);

    List<Product> retrieveAll();
}
