package com.kopo.cafe.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDTO {
    private String itemId;  // 상품 ID
    private int quantity;      // 상품 수량
//    private int pricePerUnit;  // 상품 단가
    private String name;
    private int price;
    private String selectedSize;
    
    // 총 가격 계산
    public int calculateTotalPrice() {
        return price * quantity;
    }
}
