package com.kopo.hello.cafeVO.payment;

import com.kopo.hello.cafeVO.payment.Payment;

public class ApplePayPayment implements Payment {
	
	//애플페이 처리 로직 작성
	@Override
	public String paymentWay() {
		// TODO Auto-generated method stub
		return "핸드폰을 갖다 대세요.";
	}

}
