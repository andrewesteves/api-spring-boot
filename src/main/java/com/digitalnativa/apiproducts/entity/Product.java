package com.digitalnativa.apiproducts.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Product {
    /**
     * Identificador gerado pelo MongoDB.
     */
    private String id;

    /**
     * Nome do produto.
     */
    private String name;

    /**
     * Descrição do produto.
     */
    private String description;

    /**
     * Quantidade do produto.
     */
    private int quantity;

    /**
     * Valor do produto.
     */
    private double price;
}
