package com.digitalnativa.apiproducts.vo;

import lombok.Data;

@Data
public class ProductRequest {
    private String title;
    private String description;
    private int quantity;
    private double price;
}
