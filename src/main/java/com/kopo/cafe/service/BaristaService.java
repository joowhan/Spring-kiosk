package com.kopo.cafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kopo.cafe.dao.SalesDAO;
import com.kopo.cafe.dto.OrderDTO;
import com.kopo.cafe.dto.OrderItemDTO;
import com.kopo.cafe.dto.SalesDTO;

@Service
public class BaristaService {
    private final SalesDAO salesDAO;
    @Autowired
    public BaristaService(SalesDAO salesDAO){
        this.salesDAO = salesDAO;
    }
    public void addSalesRecord(OrderDTO order) {
        for (OrderItemDTO item : order.getOrderItems()) {
            // 기존 매출 기록을 조회
            SalesDTO existingRecord = salesDAO.findSalesRecordByItemId(item.getItemId());
            if (existingRecord != null) {
                // 기존 기록이 있으면 판매 수량과 매출을 업데이트
                existingRecord.setQuantity(existingRecord.getQuantity() + item.getQuantity());
                existingRecord.setTotalSales(existingRecord.getTotalSales() + item.calculateTotalPrice());
                salesDAO.updateSalesRecord(existingRecord);
            } else {
                // 새로운 판매 기록 추가
                SalesDTO newRecord = new SalesDTO(item.getItemId(), item.getName(), item.getQuantity(), item.calculateTotalPrice());
                salesDAO.insertSalesRecord(newRecord);
            }
        }
    }

    public List<SalesDTO> getAllSales() {
        return salesDAO.getAllSales();
    }

    public int calculateTotalSales() {
        int total = 0;
        for (SalesDTO sales : salesDAO.getAllSales()) {
            total += sales.getTotalSales();
        }
        return total;
    }

}
