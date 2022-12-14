package com.example.javaspringapizmiennesciezkiiparametry;

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
    List<Product> getProduct (@RequestParam(required = false) String name){
        if (name == null){
            return productRepository.findAll();
        }else {
            return productRepository.findAllByName(name);
        }
    }
    @GetMapping("/{id}")
    Product getProductById(@PathVariable Integer id){
        return productRepository.findById(id);
    }

    @GetMapping("/{id}/producer")
    Producer getProducerById(@PathVariable Integer id){
        return productRepository.findById(id).getProducer();
    }

}
