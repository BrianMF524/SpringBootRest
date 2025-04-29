package com.application.rest.service.impl;

import com.application.rest.entities.Product;
import com.application.rest.persistence.IProductDAO;
import com.application.rest.repo.ProductRepo;
import com.application.rest.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDAO productDAO;

    @Override
    public Optional<Product> findById(Long id) {
        return productDAO.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public List<Product> findByPriceRange(BigDecimal min, BigDecimal max) {
        return productDAO.findByPriceRange(min,max);
    }

    @Override
    public void save(Product p) {
        productDAO.save(p);
    }

    @Override
    public void deleteById(Long id) {
        productDAO.deleteById(id);
    }
}
