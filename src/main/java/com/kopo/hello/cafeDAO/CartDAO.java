package com.kopo.hello.cafeDAO;

import com.kopo.hello.cafeVO.cart.Cart;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CartDAO {
    private final Map<String, Cart> cartStore = new HashMap<>(); // 간단한 메모리 저장소 사용

    // 장바구니 저장
    public void saveCart(Cart cart) {
        cartStore.put(cart.getCartId(), cart);
    }

    // 장바구니 조회
    public Cart getCartById(String cartId) {
        return cartStore.get(cartId);
    }
}
