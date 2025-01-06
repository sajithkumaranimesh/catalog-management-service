package com.cinnamon.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String price;

    @Column(name = "quantity_in_stock")
    private Integer quantityInStock;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "created_at")
    private Date createdAt;
}
