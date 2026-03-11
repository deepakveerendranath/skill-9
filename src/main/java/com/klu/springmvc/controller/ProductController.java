package com.klu.springmvc.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.klu.springmvc.entity.Product;
import com.klu.springmvc.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return repo.findByCategory(category);
    }

    @GetMapping("/filter")
    public List<Product> filter(@RequestParam double min,
                                @RequestParam double max) {
        return repo.findByPriceBetween(min, max);
    }

    @GetMapping("/sorted")
    public List<Product> sorted() {
        return repo.sortByPrice();
    }
}