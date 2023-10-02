package com.shop.component;

import com.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProductCountInfoContributor implements InfoContributor {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void contribute(Info.Builder builder) {
        long countProduct = productRepository.count();
        Map<String, Object> productMap = new HashMap<>();
        productMap.put("count", countProduct);
        builder.withDetail("product-stats", productMap);
    }
}
