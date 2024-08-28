package com.kopo.cafe.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemDTO {
	private String itemId;  // 상품 ID
	private String name;
    private int quantity;      // 상품 수량
	private int price;
    private String selectedSize;
    
    //수량 * 가격
    public int calculateTotalPrice() {
        return this.price * this.quantity;
    }
}
