package com.kopo.cafe.dto;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
	private String orderId; //주문 번호 생성 ex)001, 002,003,...
	private int orderPrice; // 주문한 아이템들의 총액
	private String pickUp; // pickup 방식 -> seesion "pickUpOption"으로 저장한 값 저장
	private ArrayList<OrderItemDTO> orderItems;
	
    // 전체 주문 가격 계산
    public int calculateTotalOrderPrice() {
        int totalPrice = 0;
        for (OrderItemDTO item : orderItems) {
            totalPrice += item.calculateTotalPrice();
        }
        return totalPrice;
    }
}
