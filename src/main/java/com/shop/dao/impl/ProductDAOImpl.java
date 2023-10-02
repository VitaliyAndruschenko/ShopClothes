package com.shop.dao.impl;

import com.shop.dao.ProductDAO;
import com.shop.model.Product;
import com.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class ProductDAOImpl extends ProductDAO<Product> {
    @Value("${upload.path}")
    private String uploadPath;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Page<Product> allProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void add(Product product, MultipartFile photoFileName) throws IOException {
        if (photoFileName != null) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            photoFileName.transferTo(new File(uploadPath + "/" + photoFileName.getOriginalFilename()));
            product.setPhotoFileName(photoFileName.getOriginalFilename());
        }
        product.setProductName(product.getProductName());
        product.setTagline(product.getTagline());
        product.setPrice(product.getPrice());
        product.setDescription(product.getDescription());
        productRepository.save(product);
    }

    @Override
    public void delete(String productName) {
        productRepository.deleteProductByProductName(productName);
    }

    @Override
    public Product update(String productName) {
        return productRepository.findProductByProductName(productName);
    }

    @Override
    public List<Product> getByProductName(String productName) {
        return productRepository.findProductsByProductNameIsContaining(productName);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.getProductById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
