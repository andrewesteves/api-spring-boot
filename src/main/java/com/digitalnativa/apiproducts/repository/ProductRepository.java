package com.digitalnativa.apiproducts.repository;

import com.digitalnativa.apiproducts.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
