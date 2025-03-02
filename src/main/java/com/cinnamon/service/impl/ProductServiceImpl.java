package com.cinnamon.service.impl;

import com.cinnamon.entity.ProductEntity;
import com.cinnamon.model.Product;
import com.cinnamon.repository.ProductRepository;
import com.cinnamon.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Product> retrieveAll() {

        List<Product> productList = new ArrayList<>();

        List<ProductEntity> productEntityList = productRepository.findAll();
        productEntityList.forEach(productEntity -> productList.add(modelMapper.map(productEntity, Product.class)));

        return productList;
    }

    @Override
    public Product retrieveById(Long id) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        return modelMapper.map(productEntity, Product.class);
    }

    @Override
    public Product updateById(Product product) {
        ProductEntity productEntity = modelMapper.map(product, ProductEntity.class);
        ProductEntity saved = productRepository.save(productEntity);

        return modelMapper.map(saved, Product.class);
    }

    @Override
    public Product deleteById(Long id) {
        productRepository.deleteById(id);
        return null;
    }
}
