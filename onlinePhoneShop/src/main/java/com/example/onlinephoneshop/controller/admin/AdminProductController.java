package com.example.onlinephoneshop.controller.admin;

import com.example.onlinephoneshop.dto.UserDTO;
import com.example.onlinephoneshop.entity.Product;
import com.example.onlinephoneshop.entity.User;
import com.example.onlinephoneshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/admin/products")
public class AdminProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<Product> insertProduct(@Valid @RequestBody Product product){
        Product newProduct = productService.save(product);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{productId}")
                .buildAndExpand(newProduct.getProductId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
