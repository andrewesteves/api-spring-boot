package com.digitalnativa.apiproducts.vo;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private String description;
    private int quantity;
    private double price;
}
