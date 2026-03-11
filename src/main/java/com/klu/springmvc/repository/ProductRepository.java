package com.klu.springmvc.repository;

import java.util.List;
import org.springframework.data.jpa.repository.*;
import com.klu.springmvc.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    @Query("SELECT p FROM Product p ORDER BY p.price")
    List<Product> sortByPrice();
}