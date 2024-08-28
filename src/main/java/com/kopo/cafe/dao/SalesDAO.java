package com.kopo.cafe.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kopo.cafe.dto.SalesDTO;

@Repository
public class SalesDAO {

    private Map<String, SalesDTO> salesData = new HashMap<>();

    public SalesDTO findSalesRecordByItemId(String itemId) {
        return salesData.get(itemId);
    }

    public void updateSalesRecord(SalesDTO record) {
        salesData.put(record.getItemId(), record);
    }

    public void insertSalesRecord(SalesDTO record) {
        salesData.put(record.getItemId(), record);
    }
    // 모든 판매 기록을 반환하는 메서드
    public List<SalesDTO> getAllSales() {
        return new ArrayList<>(salesData.values());
    }

}
