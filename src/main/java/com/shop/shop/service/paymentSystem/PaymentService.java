package com.shop.shop.service.paymentSystem;

import com.shop.shop.model.paymentSystem.PaymentCallback;
import com.shop.shop.model.paymentSystem.PaymentDetail;

public interface PaymentService {
    PaymentDetail proceedPayment(PaymentDetail paymentDetail);
    String payuCallback(PaymentCallback paymentResponse);
}
