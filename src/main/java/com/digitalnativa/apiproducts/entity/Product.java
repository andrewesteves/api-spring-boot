package com.digitalnativa.apiproducts.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Product {
    private String id;
    private String title;
    private String description;
    private int quantity;
    private double price;
}
