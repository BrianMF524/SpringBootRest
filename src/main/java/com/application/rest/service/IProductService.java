package com.application.rest.service;

import com.application.rest.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductService {
    Optional<Product> findById(Long id);
    List<Product> findAll();
    List<Product> findByPriceRange(BigDecimal min, BigDecimal max);
    void save(Product p);
    void deleteById(Long id);
}
