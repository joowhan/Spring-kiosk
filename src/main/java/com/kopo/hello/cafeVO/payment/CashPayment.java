package com.kopo.hello.cafeVO.payment;

import com.kopo.hello.cafeVO.payment.Payment;

public class CashPayment implements Payment {

	//현금 계산 로직 작성
	@Override
	public String paymentWay() {
		// TODO Auto-generated method stub
		return "현금을 계산하세요.";
	}

}
