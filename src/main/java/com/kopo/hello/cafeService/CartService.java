package com.kopo.hello.cafeService;

import com.kopo.hello.cafeDAO.CartDAO;
import com.kopo.hello.cafeVO.cart.Cart;
import com.kopo.hello.cafeVO.cart.CartItem;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartDAO cartDAO;

    @Autowired
    public CartService(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }


    // 세션에서 장바구니를 가져오거나 새로 생성
    public Cart getCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    // 장바구니에 아이템 추가
    public void addToCart(HttpSession session, String name, String itemId, int quantity, String selectedSize) {
        Cart cart = getCart(session);
        CartItem newItem = new CartItem();
        newItem.setName(name);
        newItem.setItemId(itemId);
        newItem.setQuantity(quantity);
        newItem.setSelectedSize(selectedSize); // 선택된 사이즈 설정
        cart.addItem(newItem);

        // 장바구니 저장소에 저장
        cartDAO.saveCart(cart);
    }

    // 장바구니 조회
    public Cart getCartById(String cartId) {
        return cartDAO.getCartById(cartId);
    }
}
