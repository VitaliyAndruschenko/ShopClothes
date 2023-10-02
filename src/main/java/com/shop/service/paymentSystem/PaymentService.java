package com.shop.service.paymentSystem;

import com.shop.model.paymentSystem.PaymentCallback;
import com.shop.model.paymentSystem.PaymentDetail;

public interface PaymentService {
    PaymentDetail proceedPayment(PaymentDetail paymentDetail);
    String payuCallback(PaymentCallback paymentResponse);
}
