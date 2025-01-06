package com.cinnamon.controller;

import com.cinnamon.model.Product;
import com.cinnamon.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    public Product persist(@RequestBody Product product){
        return productService.persist(product);
    }
}
