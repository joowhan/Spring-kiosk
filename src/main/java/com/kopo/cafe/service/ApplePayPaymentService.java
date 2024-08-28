package com.kopo.cafe.service;

import org.springframework.stereotype.Service;

@Service("applePayPaymentService")
public class ApplePayPaymentService implements PaymentService {
	
	//애플페이 처리 로직 작성
	@Override
	public int paymentWay() {
		// TODO Auto-generated method stub
//		return "핸드폰을 갖다 대세요.";
		return 3;
	}

}
