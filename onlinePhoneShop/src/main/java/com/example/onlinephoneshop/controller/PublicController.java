package com.example.onlinephoneshop.controller;

import com.example.onlinephoneshop.entity.Category;
import com.example.onlinephoneshop.entity.Product;
import com.example.onlinephoneshop.service.CategoryService;
import com.example.onlinephoneshop.service.ProductService;
import com.example.onlinephoneshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/public")
public class PublicController {
	@Autowired
	UserService userService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;

	@GetMapping("categories")
	public List<Category> getAllCategories(){
		return categoryService.getAllCategories();
	}

	@GetMapping("categories/{id}")
	public Optional<Category> retrieveCategory(@PathVariable String id) {
		return categoryService.findById(id);
	}

	@GetMapping("categories/search")
	public Optional<Category> getCategoryByName(@RequestParam String name) {
		return categoryService.findCategoryByName(name);
	}

	@GetMapping("products")
	public List<Product> getAllProducts(){
		return productService.getAllProduct();
	}
}