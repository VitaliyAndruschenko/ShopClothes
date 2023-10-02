package com.shop.dao;

import com.shop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public abstract class ProductDAO<T> {
    public abstract Page<T> allProduct(Pageable pageable);
    public abstract void add(T t, MultipartFile file) throws IOException;
    public abstract void delete(String productName);
    public abstract Product update(String productName);
    public abstract List<T> getByProductName(String productName);
    public abstract Product getProductById(Long id);
    public abstract List<T> getAll();
}
