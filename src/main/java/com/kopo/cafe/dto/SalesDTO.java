package com.kopo.cafe.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SalesDTO {
    private String itemId;
    private String name;
    private int quantity;
    private int totalSales;
    
    public SalesDTO(String itemId, String name, int quantity, int totalSales) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
        this.totalSales = totalSales;
    }

}
