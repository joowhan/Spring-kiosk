package com.kopo.hello.cafeVO.cart;

import com.kopo.hello.cafeVO.menu.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem {
    private String itemId;  // 상품 ID
    private int quantity;      // 상품 수량
    private String name;
    private String selectedSize;
    
    //수량 * 가격
    public int calculateTotalPrice(int pricePerUnit) {
        return pricePerUnit * quantity;
    }
}
