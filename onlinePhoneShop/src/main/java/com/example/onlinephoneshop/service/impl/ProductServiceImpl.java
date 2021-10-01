package com.example.onlinephoneshop.service.impl;

import com.example.onlinephoneshop.entity.Product;
import com.example.onlinephoneshop.repository.ProductRepository;
import com.example.onlinephoneshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
