package com.kopo.hello.cafeVO.payment;

import com.kopo.hello.cafeVO.payment.Payment;

public class CardPayment implements Payment {
	
	// 카드 처리 로직 작성
	@Override
	public String paymentWay() {
		// TODO Auto-generated method stub
		return "신용카드를 투입하세요.";
	}


}
