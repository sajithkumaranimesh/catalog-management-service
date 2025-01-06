package com.cinnamon.service.impl;

import com.cinnamon.entity.ProductEntity;
import com.cinnamon.model.Product;
import com.cinnamon.repository.ProductRepository;
import com.cinnamon.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Product persist(Product product) {
        ProductEntity productEntity = modelMapper.map(product, ProductEntity.class);

        productEntity.setCreatedAt(new Date());

        ProductEntity saved = productRepository.save(productEntity);

        return modelMapper.map(saved, Product.class);
    }
}
