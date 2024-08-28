package com.kopo.cafe.service;

import org.springframework.stereotype.Service;

@Service("cardPaymentService")
public class CardPaymentService implements PaymentService {
	
	// 카드 처리 로직 작성
	@Override
	public int paymentWay() {
		// TODO Auto-generated method stub
//		return "신용카드를 투입하세요.";
		return 2;
	}


}
