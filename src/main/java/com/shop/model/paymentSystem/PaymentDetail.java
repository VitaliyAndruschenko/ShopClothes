package com.shop.model.paymentSystem;

import lombok.Data;

@Data
public class PaymentDetail {
    private String email;
    private String name;
    private String phone;
    private String productInfo;
    private String amount;
    private String txnId;
    private String hash;
    private String sUrl;
    private String fUrl;
    private String key;
}
