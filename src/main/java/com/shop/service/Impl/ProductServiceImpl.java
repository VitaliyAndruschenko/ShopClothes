package com.shop.service.Impl;

import com.shop.dao.ProductDAO;
import com.shop.dto.ProductDTO;
import com.shop.model.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO<Product> productDAO;
    @Override
    public void addProduct(Product product, MultipartFile photoFileName) throws IOException {
        productDAO.add(product, photoFileName);
    }

    @Override
    public void deleteProduct(String productName) {
        productDAO.delete(productName);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
       return productDAO.allProduct(pageable);
    }

    @Override
    public List<Product> findByProductName(String productName) {
        return productDAO.getByProductName(productName);
    }

    @Override
    public Product updateProduct(ProductDTO productDTO,  MultipartFile photoFileName) throws IOException {
        Product product = productDAO.getProductById(productDTO.getId());
        product.setProductName(productDTO.getProductName());
        product.setTagline(productDTO.getTagline());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setPhotoFileName(photoFileName.getOriginalFilename());
        product.setId(product.getId());
        productDAO.add(product, photoFileName);
        return product;
    }

    @Override
    public Product getProductById(Long id) {
        return productDAO.getProductById(id);
    }
}
