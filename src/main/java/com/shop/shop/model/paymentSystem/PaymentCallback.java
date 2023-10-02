package com.shop.shop.model.paymentSystem;

import com.shop.shop.enums.PaymentMode;
import lombok.Data;

@Data
public class PaymentCallback {
    private String txnid;
    private String mihpayid;
    private PaymentMode mode;
    private String status;
    private String hash;
}
