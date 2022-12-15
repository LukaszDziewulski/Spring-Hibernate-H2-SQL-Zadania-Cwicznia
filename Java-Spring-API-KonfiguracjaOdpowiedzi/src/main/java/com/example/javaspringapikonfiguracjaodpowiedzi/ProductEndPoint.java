package com.example.javaspringapikonfiguracjaodpowiedzi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductEndPoint {

    private final ProductRepository productRepository;


    public ProductEndPoint(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    List<Product> getProduct(@RequestParam(required = false) String name) {
        if (name == null) {
            return productRepository.findAll();
        } else {
            return productRepository.findAllByName(name);
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/producer")
    ResponseEntity<Producer> getProducerById(@PathVariable Integer id) {
        return productRepository.findById(id)
                .map(Product::getProducer)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/example")
    @ResponseStatus(HttpStatus.CREATED)
    void example() {
    }
}
