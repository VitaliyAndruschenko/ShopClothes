package com.shop.dto;

import com.shop.model.Product;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductDTO {
    private Long id;
    private String productName;
    private String tagline;
    private Integer price;
    private String description;
    private MultipartFile photoFileName;
    private String countInBasket;

    public Product addProduct(String productName, String tagline,
                              Integer price, String description, MultipartFile multipartFile) {
        Product product = new Product();
        product.setProductName(productName);
        product.setTagline(tagline);
        product.setPrice(price);
        product.setDescription(description);
        product.setPhotoFileName(multipartFile.getOriginalFilename());
        return product;
    }


    public ProductDTO(Long id, String productName, String tagline, Integer price, String description, MultipartFile photoFileName, String countInBasket) {
        this.id = id;
        this.productName = productName;
        this.tagline = tagline;
        this.price = price;
        this.description = description;
        this.photoFileName = photoFileName;
        this.countInBasket = countInBasket;
    }
}
