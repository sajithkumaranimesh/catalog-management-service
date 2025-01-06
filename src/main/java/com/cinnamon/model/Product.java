package com.cinnamon.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Product {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantityInStock;
    private String imageUrl;
}
