package com.example.onlinephoneshop.service;

import com.example.onlinephoneshop.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProduct();
    Product save(Product product);
}
