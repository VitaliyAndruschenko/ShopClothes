package com.shop.model.paymentSystem;

import com.shop.enums.PaymentMode;
import lombok.Data;

@Data
public class PaymentCallback {
    private String txnid;
    private String mihpayid;
    private PaymentMode mode;
    private String status;
    private String hash;
}
