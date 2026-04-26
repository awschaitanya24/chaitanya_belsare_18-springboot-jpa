/**
 * 
 */
package com.example.data_JPA_workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.data_JPA_workshop.entity.Product;
import com.example.data_JPA_workshop.repository.ProductRepository;
import com.example.data_JPA_workshop.view.ProductView;

/**
 * 
 */
@Service
// @component is generic -->@service define that it contain business logic
public class ProductService {

	// Dependency Injection - DI OR IOC (Inversion of Control)

	// One class dependent on anther class
	// Types of DI
	// 1. Field Injection
	// 2. Constructor Injection:- Best- loose cupping,null pointer handling ,
	// immutability
	// 3. Setter Injection

	/*@Autowired
	private ProductRepository repo1;*/

	private final ProductRepository repo2;

	public ProductService(ProductRepository repo2) {
		this.repo2 = repo2;
	}

	/*private ProductRepository repo3;

	public void setRepo3(ProductRepository repo3) {
		this.repo3 = repo3;
	}*/

	public List<Product> getAllProducts() {

		return repo2.findAll();

		// Select * from products

	}
	
	// FindAll with pagination & Sorting
	public List<Product> getProducts(int page, int size) {
		PageRequest pageable = PageRequest.of(page, size, Sort.by("productPrice").descending());
		Page<Product> p = repo2.findAll(pageable);
		System.out.println(p.toString());
		return p.getContent();
	}
	
	public List<ProductView> getProductsByName(String name) {
		return repo2.findByProductName(name);
		// Select name, price from products where name = ?
	}

	public String addProduct(Product product) {

		repo2.save(product);

		// Insert into products (name, price, description) values (?, ?, ?)

		return "Product added successfully";

	}

	public String deleteProduct(int id) {

		if (repo2.existsById(id)) { // select count(*) from products where id = ?

			repo2.deleteById(id);

			// Delete from products where id = ?

			return "Product deleted successfully";

		} else {

			return "Product not found";

		}

	}

	public String updateProduct(int id, Product updatedProduct) {

		if (repo2.existsById(id)) {

			updatedProduct.getProductId();
			repo2.save(updatedProduct);

			// Update products set name = ?, price = ?, description = ? where id = ?

			return "Product updated successfully";

		} else {

			return "Product not found";

		}

	}
}
