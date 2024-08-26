package com.kopo.hello.cafeVO.order;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
	private String orderId;
	private int orderPrice;
	private ArrayList<OrderItem> orderItems;
	
    // 전체 주문 가격 계산
    public int calculateTotalOrderPrice() {
        int totalPrice = 0;
        for (OrderItem item : orderItems) {
            totalPrice += item.calculateTotalPrice();
        }
        return totalPrice;
    }
}
