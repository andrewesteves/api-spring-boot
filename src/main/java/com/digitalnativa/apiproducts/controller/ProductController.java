package com.digitalnativa.apiproducts.controller;

import com.digitalnativa.apiproducts.entity.Product;
import com.digitalnativa.apiproducts.repository.ProductRepository;
import com.digitalnativa.apiproducts.vo.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> show(@PathVariable String id) {
        Optional<Product> product = productRespository.findById(id);
        if(!product.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> store(@RequestBody @Valid ProductRequest request) {
        Product product = new Product();
        product.setTitle(request.getTitle());
        product.setDescription(request.getDescription());
        product.setQuantity(request.getQuantity());
        product.setPrice(request.getPrice());
        productRespository.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
