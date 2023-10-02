package com.shop.repository;

import com.shop.model.OrderProductInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCountRepository extends JpaRepository<OrderProductInformation, Long> {
}
