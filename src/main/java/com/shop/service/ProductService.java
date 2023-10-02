package com.shop.service;

import com.shop.dto.ProductDTO;
import com.shop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    void addProduct(Product product, MultipartFile photoFileName) throws IOException;
    void deleteProduct(String productName);
    Page<Product> findAll(Pageable pageable);
    List<Product> findByProductName(String productName);
    Product updateProduct(ProductDTO productDTO, MultipartFile photoFileName) throws IOException;
    Product getProductById(Long id);
}
