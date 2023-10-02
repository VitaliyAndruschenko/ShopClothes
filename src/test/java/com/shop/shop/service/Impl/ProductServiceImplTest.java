package com.shop.shop.service.Impl;

import com.shop.dao.ProductDAO;
import com.shop.dto.ProductDTO;
import com.shop.model.Product;
import com.shop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class ProductServiceImplTest {
    @Autowired
    ProductService productService;
    @Autowired
    ProductDAO productDAO;

    @Test
    void addProduct() throws IOException {
        MultipartFile multipartFile = null;
        Product product = new Product("Soap", "Test", 13, "Test", "Test", "5");
        productService.addProduct(product, multipartFile);
        Product product1 = productService.getProductById(product.getId());
        assertEquals(product1.getProductName(), product.getProductName());
        assertEquals(product.getPrice(), product.getPrice());
        productService.deleteProduct(product.getProductName());
    }

    @Test
    void deleteProduct() throws IOException {
        Product product = new Product("Soap", "Test", 13, "Test", "Test", "5");
        MultipartFile multipartFile = null;
        productService.addProduct(product, multipartFile);
        productService.deleteProduct(product.getProductName());
        List<Product> productList = new ArrayList<>();
        assertEquals(productService.findByProductName("Soap"), productList);
        productService.deleteProduct(product.getProductName());
    }

    @Test
    void findAll() {
        Pageable pageable = Pageable.ofSize(6);
        Page<Product> productList = productService.findAll(pageable);
        assertEquals(productList.getTotalElements(), 6);
    }

    @Test
    void findByProductName() throws IOException {
        Product product = new Product("Soap", "Test", 13, "Test", "Test", "5");
        MultipartFile multipartFile = null;
        productService.addProduct(product, multipartFile);
        List<Product> productList = productService.findByProductName(product.getProductName());
        assertNotNull(productList);
        assertEquals(productList.size(), 1);
        assertEquals(productList.get(0).getProductName(), product.getProductName());
        assertEquals(productList.get(0).getPrice(), product.getPrice());
    }

    @Test
    void updateProduct() throws IOException {
        MockMultipartFile multipartFile = new MockMultipartFile("file", "my.file.txt","text/plain", "Hello, world!".getBytes());
        ProductDTO productDTO = new ProductDTO(1L,"Soap", "Test", 13, "Test", multipartFile, "5");
        Product product = productService.getProductById(productDTO.getId());
        product.setProductName(productDTO.getProductName());
        product.setTagline(productDTO.getTagline());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setId(product.getId());
        productService.updateProduct(productDTO, multipartFile);
        Product product1 = productService.getProductById(productDTO.getId());
        assertEquals(product1.getProductName(), product.getProductName());
        assertEquals(product1.getPrice(), product.getPrice());
        productService.deleteProduct(product.getProductName());

    }

    @Test
    void getProductById() throws IOException {
        Product product = new Product("Soap", "Test", 13, "Test", "Test", "5");
        MultipartFile multipartFile = null;
        productService.addProduct(product, multipartFile);
        Product product1 = productService.getProductById(product.getId());
        assertEquals(product.getProductName(), product1.getProductName());
        assertEquals(product.getPrice(), product1.getPrice());
        productService.deleteProduct(product.getProductName());
    }
}