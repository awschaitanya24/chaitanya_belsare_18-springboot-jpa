package com.example.data_JPA_workshop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.data_JPA_workshop.entity.Product;
import com.example.data_JPA_workshop.service.ProductService;
import com.example.data_JPA_workshop.view.ProductView;

@RestController
public class ProductController {
	
	

	private ProductService service;	
	public ProductController(ProductService service) {
		this.service = service;
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}

	@PostMapping("/products")
	public String addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}

	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}

	@PutMapping("/products/{id}")
	public String updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
		return service.updateProduct(id, updatedProduct);
	}
	
	@GetMapping("/products/page/{page}/size/{size}")
	public List<Product> getProducts(@PathVariable int page, @PathVariable int size) {
		return service.getProducts(page, size);
	}
	
	@GetMapping("/products/name/{name}")
	public List<ProductView> getProductsByName(@PathVariable String name) {
		return service.getProductsByName(name);
	}
}
