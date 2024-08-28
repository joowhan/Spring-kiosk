package com.kopo.cafe.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kopo.cafe.service.ApplePayPaymentService;
import com.kopo.cafe.service.CardPaymentService;
import com.kopo.cafe.service.CashPaymentService;
import com.kopo.cafe.service.PaymentService;

@Component
public class PaymentFactory {
    private final Map<String, PaymentService> paymentServices = new HashMap<>();

    @Autowired
    public PaymentFactory(
    		CardPaymentService cardPaymentService, 
            ApplePayPaymentService applePayPaymentService, 
            CashPaymentService cashPaymentService) {
        paymentServices.put("credit", cardPaymentService);
        paymentServices.put("applepay", applePayPaymentService);
        paymentServices.put("cash", cashPaymentService);
    }

    public PaymentService getPaymentService(String method) {
        return paymentServices.get(method);
    }
}
