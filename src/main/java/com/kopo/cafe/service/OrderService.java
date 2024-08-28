package com.kopo.cafe.service;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kopo.cafe.dao.OrderDAO;
import com.kopo.cafe.dto.OrderDTO;

@Service
public class OrderService {
	/*
	AtomicLong은 멀티 스레드 환경에서 원자적으로
  	(long 변수의 값을 변경하는 동작이 원자적으로 실행되어 스레드간의 경쟁이 없도록 보장해주는)
	연산을 수행할 수 있도록 도와주는 클래스 -> atomic 한 주문 번호를 위해 사용
	*/
	private static final AtomicLong orderIdCounter = new AtomicLong(0);

	@Autowired
	private OrderDAO orderDAO;

	// 고유한 orderId 생성 메소드
	public String generateOrderId() {
		long nextOrderId = orderIdCounter.incrementAndGet();
		return String.format("%03d", nextOrderId); // 001, 002 형식으로 생성
	}
	// 주문 저장
	public void saveOrder(OrderDTO order) {
		orderDAO.saveOrder(order);
	}

	// 특정 주문 조회
	public OrderDTO getOrderById(String orderId) {
		return orderDAO.getOrderById(orderId);
	}

	// 모든 주문 조회 (예시로 추가)
	public Map<String, OrderDTO> getAllOrders() {
		return orderDAO.getAllOrders();
	}

	// 주문 처리
	public void removeOrder(String orderId) {
		// OrderDAO에서 주문 제거
		orderDAO.deleteOrderById(orderId);
	}
}
