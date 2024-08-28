package com.kopo.cafe.service;

import org.springframework.stereotype.Service;

@Service("cashPaymentService")
public class CashPaymentService implements PaymentService {

	//현금 계산 로직 작성
	@Override
	public int paymentWay() {
		// TODO Auto-generated method stub
//		return "현금을 계산하세요."; // 인코딩 에러로 숫자 리턴으로 변경 
		return 1;
	}

}
