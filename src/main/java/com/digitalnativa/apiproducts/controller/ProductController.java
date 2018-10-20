package com.digitalnativa.apiproducts.controller;

import com.digitalnativa.apiproducts.entity.Product;
import com.digitalnativa.apiproducts.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRespository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> index() {
        List<Product> products = productRespository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
