package com.shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String tagline;
    private Integer price;
    private String description;
    private String photoFileName;
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Set<OrderProductInformation> orderProductInformationSet;
    @Transient
    private String countInBasket;

    public Product(String productName, String tagline, Integer price, String description, String photoFileName, String countInBasket) {
        this.productName = productName;
        this.tagline = tagline;
        this.price = price;
        this.description = description;
        this.photoFileName = photoFileName;
        this.countInBasket = countInBasket;
    }
}
