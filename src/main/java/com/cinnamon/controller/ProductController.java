package com.cinnamon.controller;

import com.cinnamon.model.Product;
import com.cinnamon.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    public Product persist(@RequestBody Product product){
        return productService.persist(product);
    }

    @GetMapping()
    public List<Product> retrieveAll(){
        return productService.retrieveAll();
    }

    @GetMapping("/{id}")
    public Product retrieveById(@PathVariable Long id){
        return productService.retrieveById(id);
    }

    @PatchMapping()
    public Product updateById(@RequestBody Product product){
        return productService.updateById(product);
    }

    @DeleteMapping("/{id}")
    public Product deleteById(@PathVariable Long id){
        return productService.deleteById(id);
    }
}
