package com.kopo.hello.cafeController;

import com.kopo.hello.cafeService.CartService;
import com.kopo.hello.cafeVO.cart.Cart;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    // 장바구니 페이지로 이동
    @GetMapping("/cart")
    public String showCartPage(HttpSession session, Model model) {
        Cart cart = cartService.getCart(session);
        if (cart != null && !cart.isEmpty()) {
            model.addAttribute("cartItemCount", cart.getItemCount());
        } else {
            model.addAttribute("cartItemCount", 0);
        }
        model.addAttribute("cart", cart);
        return "cart"; // cart.jsp 파일로 이동
    }

    // 장바구니에 아이템 추가
    @PostMapping("/cart/add")
    @ResponseBody
    public Map<String, Object> addToCart(
            @RequestParam("itemId") String itemId,
            @RequestParam("quantity") int quantity,
            @RequestParam("name") String name,
            @RequestParam("selectedSize") String selectedSize,
            HttpSession session) {
        cartService.addToCart(session, name, itemId, quantity, selectedSize);
        Cart cart = cartService.getCart(session);
        System.out.println("Cart added: "+name+" "+itemId +" " + quantity +" " +selectedSize);
//        return "redirect:/menu/detail?id=" + itemId; // 현재 상세 페이지로 리다이렉트
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("cartItemCount", cart.getItemCount());
        return response;
    }
}
