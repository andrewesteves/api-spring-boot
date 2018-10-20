package com.digitalnativa.apiproducts.repository;

import com.digitalnativa.apiproducts.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    public List<Product> findByTitle(String title);
}
