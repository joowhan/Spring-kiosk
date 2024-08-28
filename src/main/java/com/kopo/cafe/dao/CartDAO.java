package com.kopo.cafe.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kopo.cafe.dto.CartDTO;

@Repository
public class CartDAO {
    private final Map<String, CartDTO> cartStore = new HashMap<>(); // 간단한 메모리 저장소 사용

    // 장바구니 저장
    public void saveCart(CartDTO cart) {
        cartStore.put(cart.getCartId(), cart);
    }

    // 장바구니 조회
    public CartDTO getCartById(String cartId) {
        return cartStore.get(cartId);
    }
}
