package com.kopo.cafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kopo.cafe.model.PaymentFactory;
import com.kopo.cafe.service.PaymentService;

@Controller
public class PaymentController {
	
    @Autowired
    private PaymentFactory paymentFactory;
    
    @RequestMapping("/payment")
    @ResponseBody
    public int getPaymentMessage(@RequestParam("method") String method) {
        PaymentService paymentService = paymentFactory.getPaymentService(method);
//        return (String) paymentService.paymentWay(); // 결제 방식 준비 -> 인코딩 문제로 숫자 return으로 변경 
        return paymentService.paymentWay();
    }

}
