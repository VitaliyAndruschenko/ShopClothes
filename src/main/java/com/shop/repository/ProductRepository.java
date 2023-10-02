package com.shop.repository;

import com.shop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Page<Product> findAll(Pageable pageable);
    void deleteProductByProductName(String productName);
    List<Product> findProductsByProductNameIsContaining(String productName);
    Product findProductByProductName(String productName);
    Product getProductById(Long id);
}
