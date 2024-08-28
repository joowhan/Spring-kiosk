package com.kopo.cafe.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kopo.cafe.dto.OrderDTO;

@Repository
public class OrderDAO {
    // 메모리 내의 주문 저장소
    private final Map<String, OrderDTO> orderStore = new HashMap<>();

    // 주문 저장
    public void saveOrder(OrderDTO order) {
        orderStore.put(order.getOrderId(), order);
    }

    // 특정 주문 조회
    public OrderDTO getOrderById(String orderId) {
        return orderStore.get(orderId);
    }

    // 모든 주문 조회 (예시로 추가)
    public Map<String, OrderDTO> getAllOrders() {
        return orderStore;
    }


    // 제거
    public void deleteOrderById(String orderId){
        if (orderStore.containsKey(orderId)) {
            orderStore.remove(orderId);
            System.out.println("Order with ID: " + orderId + " has been deleted.");
        } else {
            System.out.println("Order with ID: " + orderId + " not found.");
        }
    }

}
