package com.kopo.cafe.controller;

import com.kopo.cafe.dto.CartDTO;
import com.kopo.cafe.dto.CartItemDTO;
import com.kopo.cafe.dto.MenuDTO;
import com.kopo.cafe.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

@Controller
public class CartController {
	private final CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	// 장바구니 페이지로 이동
	@RequestMapping("/cart")
	public String showCartPage(HttpSession session, Model model) {
		CartDTO cart = (CartDTO) session.getAttribute("cart");
		if (cart == null) {
			cart = new CartDTO();
			session.setAttribute("cart", cart);
		}

		int totalPrice = cartService.calculateTotalPrice(cart); // 장바구니의 총 가격 계산
		System.out.println(totalPrice);
		model.addAttribute("totalPrice", totalPrice); // 총 가격을 JSP에 전달
		return "cart"; // cart.jsp 파일로 이동
	}

	// 장바구니에 아이템 추가 -> ajax 방식
//    @RequestMapping("/cart/add")
//    @ResponseBody
//    public Map<String, Object> addToCart(
//            @RequestParam("itemId") String itemId,
//            @RequestParam("quantity") int quantity,
//            @RequestParam("name") String name,
//            @RequestParam("selectedSize") String selectedSize,
//            HttpSession session) {
//        cartService.addToCart(session, name, itemId, quantity, selectedSize);
//        Cart cart = cartService.getCart(session);
//        System.out.println("Cart added: "+name+" "+itemId +" " + quantity +" " +selectedSize);
////        return "redirect:/menu/detail?id=" + itemId; // 현재 상세 페이지로 리다이렉트
//        Map<String, Object> response = new HashMap<>();
//        response.put("success", true);
//        response.put("cartItemCount", cart.getItemCount());
//        return response;
//    }
	@RequestMapping("/cart/add")
	public String addToCart(@RequestParam("itemId") String itemId, @RequestParam("name") String name,
			@RequestParam("quantity") int quantity, @RequestParam("price") int price,
			@RequestParam("selectedSize") String selectedSize, HttpSession session) {
		// 카트에 추가
		cartService.addToCart(session, name, itemId, quantity, price, selectedSize);
		// 세션에서 카트 불러오기
		CartDTO cart = cartService.getCart(session);
		System.out.println("Cart added: " + name + " " + itemId + " " + quantity + " " + selectedSize);
		// 카트에 담긴 개수 구하기
		session.setAttribute("cartItemCount", cart.getItemCount());
		return "redirect:/menu/detail?id=" + itemId;
	}
	
	@RequestMapping("/cart/addAndOrder")
	public String addAndOrder(@RequestParam("itemId") String itemId, @RequestParam("name") String name,
			@RequestParam("quantity") int quantity, @RequestParam("price") int price,
			@RequestParam("selectedSize") String selectedSize, HttpSession session) {
		// 카트에 추가
		cartService.addToCart(session, name, itemId, quantity, price, selectedSize);
		// 세션에서 카트 불러오기
		CartDTO cart = cartService.getCart(session);
		System.out.println("Cart added: " + name + " " + itemId + " " + quantity + " " + selectedSize);
		// 카트에 담긴 개수 구하기
		session.setAttribute("cartItemCount", cart.getItemCount());
		return "redirect:/cart";
	}
	
	// 카트 초기화
	@RequestMapping("/cart/clear")
	public String clearSession(HttpSession session) {
		session.removeAttribute("cart");
		session.removeAttribute("cartItemCount");
		return "redirect:/cart";
	}

}
