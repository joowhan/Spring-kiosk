package com.kopo.hello.cafeVO.cart;


import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
    private String cartId; // 고유 cartId
    private String orderId;  // 사용자를 식별하기 위한 ID
    private ArrayList<CartItem> items = new ArrayList<>(); ;  // 장바구니에 있는 아이템 리스트

    // 장바구니에 아이템 추가
    public void addItem(CartItem item) {
        items.add(item);
    }

    // 장바구니가 비어 있는지 확인
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // 장바구니 아이템 수 반환
    public int getItemCount() {
        return items.size();
    }
}