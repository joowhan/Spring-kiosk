package com.kopo.cafe.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kopo.cafe.dao.CartDAO;
import com.kopo.cafe.dto.CartDTO;
import com.kopo.cafe.dto.CartItemDTO;

@Service
public class CartService {

    private final CartDAO cartDAO;

    @Autowired
    public CartService(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }


    // 세션에서 장바구니를 가져오거나 새로 생성
    public CartDTO getCart(HttpSession session) {
        CartDTO cart = (CartDTO) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartDTO();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    // 장바구니에 아이템 추가
    public void addToCart(HttpSession session, String name, String itemId, int quantity, int price,String selectedSize) {
        CartDTO cart = getCart(session);
        CartItemDTO newItem = new CartItemDTO();
        newItem.setName(name);
        newItem.setItemId(itemId);
        newItem.setQuantity(quantity);
        newItem.setPrice(price);
        newItem.setSelectedSize(selectedSize); // 선택된 사이즈 설정
        cart.addItem(newItem);

        // 장바구니 저장소에 저장
        cartDAO.saveCart(cart);
    }

    // 장바구니 조회
    public CartDTO getCartById(String cartId) {
        return cartDAO.getCartById(cartId);
    }
    
    // 장바구니의 총 가격 계산
    public int calculateTotalPrice(CartDTO cart) {
        if (cart == null || cart.isEmpty()) {
            return 0;
        }
        int totalPrice = 0;
        for (CartItemDTO item : cart.getItems()) {
            totalPrice += item.getPrice() * item.getQuantity(); // 가격과 수량을 곱하여 총합 계산
        }
        
        return totalPrice;
    }
}
