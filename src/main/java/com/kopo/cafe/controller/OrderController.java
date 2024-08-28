package com.kopo.cafe.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kopo.cafe.dto.CartDTO;
import com.kopo.cafe.dto.CartItemDTO;
import com.kopo.cafe.dto.OrderDTO;
import com.kopo.cafe.dto.OrderItemDTO;
import com.kopo.cafe.dto.SalesDTO;
import com.kopo.cafe.global.util.PickUp;
import com.kopo.cafe.model.PaymentFactory;
import com.kopo.cafe.service.BaristaService;
import com.kopo.cafe.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentFactory paymentFactory;

    @Autowired
    private BaristaService baristaService;

    @RequestMapping("/complete")
    public String completeOrder(@RequestParam("method") String method, HttpSession session, Model model) {
        // 결제 방식에 따라 주문을 처리하는 로직
    	

        // 세션에서 장바구니와 픽업 정보를 가져옴
        CartDTO cart = (CartDTO) session.getAttribute("cart");
        if (cart == null || cart.isEmpty()) {
            model.addAttribute("message", "장바구니가 비어 있습니다.");
            return "orderComplete";
        }
        PickUp pickUp = (PickUp) session.getAttribute("pickUpOption");
        OrderDTO order = new OrderDTO();
        order.setOrderId(orderService.generateOrderId()); // 고유한 orderId 설정
        order.setPickUp(pickUp.getPickUpType());

        //카트 목록 아이템을 주문에 넣기
        ArrayList<OrderItemDTO> orderItems = new ArrayList<>();
        for (CartItemDTO cartItem : cart.getItems()) {
            OrderItemDTO orderItem = new OrderItemDTO();
            orderItem.setItemId(cartItem.getItemId());
            orderItem.setName(cartItem.getName());
            orderItem.setPrice(cartItem.getPrice());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setSelectedSize(cartItem.getSelectedSize());
            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);
        order.setOrderPrice(order.calculateTotalOrderPrice());

        // 주문 저장 및 처리 로직
        orderService.saveOrder(order);

        // 세션에서 장바구니 제거 또는 초기화
        session.removeAttribute("cart");
        session.removeAttribute("cartItemCount");

        // 주문 완료 페이지로 이동
        model.addAttribute("message", "주문이 완료되었습니다! 결제 방법: " + method);
        model.addAttribute("orderId", order.getOrderId());
        return "orderComplete";
    }
    
    // 바리스타 화면 접근
    @RequestMapping("/barista")
    public String viewOrders(Model model) {
        Map<String, OrderDTO> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "barista";
    }
    
    // 바리스타 주문 완료
    @RequestMapping("/barista/process")
    public String processOrder(@RequestParam("orderId") String orderId, @RequestParam("action") String action, Model model) {
//        baristaService.processOrder(orderId, action);
        baristaService.addSalesRecord(orderService.getOrderById(orderId));
        // 완료된 주문은 목록에서 제거
        orderService.removeOrder(orderId);
        return "redirect:/order/barista";
    }
    
    //총 매출, 판매 현황 확인
    @RequestMapping("/sales")
    public String viewSales(Model model){
        List<SalesDTO> salesList = baristaService.getAllSales();
        int totalSales = baristaService.calculateTotalSales();

        model.addAttribute("salesList", salesList);
        model.addAttribute("totalSales", totalSales);

        return "totalSales";
    }

}