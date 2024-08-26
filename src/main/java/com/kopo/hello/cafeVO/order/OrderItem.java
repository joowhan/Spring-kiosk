package com.kopo.hello.cafeVO.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItem {
    private String itemId;  // 상품 ID
    private int quantity;      // 상품 수량
    private int pricePerUnit;  // 상품 단가
    
    // 총 가격 계산
    public int calculateTotalPrice() {
        return pricePerUnit * quantity;
    }
}
