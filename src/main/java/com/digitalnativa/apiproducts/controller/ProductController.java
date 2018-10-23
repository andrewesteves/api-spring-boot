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

    /**
     * Consulta por todos os produtos cadastrados.
     *
     * @return ResponseEntity<List<Product>>
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> index() {
        List<Product> products = productRespository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Consulta por um produto específico de acordo com o id.
     *
     * @param id
     * @return ResponseEntity<Product>
     */
    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> show(@PathVariable String id) {
        Optional<Product> product = productRespository.findById(id);
        if(!product.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

    /**
     * Cadastrar um novo produto.
     *
     * @param request
     * @return ResponseEntity<Void>
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> store(@RequestBody @Valid ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setQuantity(request.getQuantity());
        product.setPrice(request.getPrice());
        productRespository.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Atualizar um produto.
     *
     * @param id
     * @param request
     * @return ResponseEntity<Void>
     */
    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody @Valid ProductRequest request) {
        Optional<Product> product = productRespository.findById(id);
        if(!product.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        product.get().setName(request.getName());
        product.get().setDescription(request.getDescription());
        product.get().setQuantity(request.getQuantity());
        product.get().setPrice(request.getPrice());
        productRespository.save(product.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Atualizar partes de um produto.
     *
     * @param id
     * @param request
     * @return ResponseEntity<Void>
     */
    @RequestMapping(path = "{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Void> edit(@PathVariable String id, @RequestBody @Valid ProductRequest request) {
        Optional<Product> product = productRespository.findById(id);
        if(!product.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(request.getName() != null) {
            product.get().setName(request.getName());
        }

        if(request.getDescription() != null) {
            product.get().setDescription(request.getDescription());
        }

        if(request.getQuantity() > 0) {
            product.get().setQuantity(request.getQuantity());
        }

        if(request.getPrice() > 0) {
            product.get().setPrice(request.getPrice());
        }

        productRespository.save(product.get());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Remover um produto cadastrado.
     *
     * @param id
     * @return ResponseEntity<Void>
     */
    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> destroy(@PathVariable String id) {
        Optional<Product> product = productRespository.findById(id);
        if(!product.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        productRespository.delete(product.get());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Consultar um produto pelo nome.
     *
     * @param name
     * @return ResponseEntity<List<Product>>
     */
    @RequestMapping(path = "search/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> search(@PathVariable String name) {
        List<Product> products = productRespository.findByName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
