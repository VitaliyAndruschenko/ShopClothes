package com.shop.shop.repository;

import com.shop.shop.model.paymentSystem.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer> {
    Payment findByTxnId(String txnId);
}
