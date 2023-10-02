package com.shop.model.paymentSystem;

import com.shop.enums.PaymentMode;
import com.shop.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "Payment")
public class Payment {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String email;
    @Column
    private String name;
    @Column
    private String phone;
    @Column
    private String productInfo;
    @Column
    private Double amount;
    @Column
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @Column
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    @Column
    private String txnId;
    @Column
    private String mihpayId;
    @Column
    @Enumerated(EnumType.STRING)
    private PaymentMode mode;
}
