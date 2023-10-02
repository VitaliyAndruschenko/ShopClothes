package com.shop.REST.controllers;

import com.shop.dto.ProductDTO;
import com.shop.model.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1//office")
public class RestOfficeController {
    @Autowired
    public ProductService productService;

    @GetMapping("/getProducts")
    public ResponseEntity<Page<Product>> getProductPage() {
        Page<Product> productList = productService.findAll(Pageable.ofSize(4));
        if (productList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productList);
    }
    @PostMapping("/addProduct")
    public ResponseEntity<Void> addProduct(@RequestBody Product product,
                                           MultipartFile multipartFile) throws IOException {
        productService.addProduct(product, multipartFile);
        return ResponseEntity.created(null).build();
    }
    @DeleteMapping("/deleteProduct")
    public ResponseEntity<Product> deleteProduct(@RequestParam String productName) {
        productService.deleteProduct(productName);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/findProduct")
    public ResponseEntity<List<Product>> findProductByName(@RequestParam String productName) {
        List<Product> productList = productService.findByProductName(productName);
        return ResponseEntity.ok(productList);
    }
    @PatchMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDTO productDTO,
                                                 @RequestPart("file") MultipartFile photoFileName
                                               ) throws IOException {
        Product updatedProduct = productService.updateProduct(productDTO, photoFileName);
        if (updatedProduct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.created(null).build();
    }
}
