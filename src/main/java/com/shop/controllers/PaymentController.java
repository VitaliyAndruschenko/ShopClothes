package com.shop.controllers;

import com.shop.model.paymentSystem.PaymentCallback;
import com.shop.model.paymentSystem.PaymentDetail;
import com.shop.service.paymentSystem.PaymentService;
import com.shop.enums.PaymentMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ModelAndView viewPaymentPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("paymentview");
        return model;
    }

    @PostMapping(path = "/payment-details")
    public @ResponseBody PaymentDetail proceedPayment(@RequestBody PaymentDetail paymentDetail) {
        return paymentService.proceedPayment(paymentDetail);
    }

    @RequestMapping(path = "/payment-response", method = RequestMethod.POST)
    public @ResponseBody String payuCallback(@RequestParam String mihpayid,
                                             @RequestParam String status,
                                             @RequestParam PaymentMode mode,
                                             @RequestParam String txnid,
                                             @RequestParam String hash) {
        PaymentCallback paymentCallback = new PaymentCallback();
        paymentCallback.setMihpayid(mihpayid);
        paymentCallback.setTxnid(txnid);
        paymentCallback.setMode(mode);
        paymentCallback.setHash(hash);
        paymentCallback.setStatus(status);
        return paymentService.payuCallback(paymentCallback);
    }
}