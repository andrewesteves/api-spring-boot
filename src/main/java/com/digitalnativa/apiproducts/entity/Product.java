package com.digitalnativa.apiproducts.entity;

import lombok.Data;

@Data
public class Product {
    private String id;
    private String title;
    private String description;
    private int quantity;
    private double price;
}
