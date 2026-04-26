/**
 * 
 */
package com.example.data_JPA_workshop.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.data_JPA_workshop.entity.Product;
import com.example.data_JPA_workshop.view.ProductView;

/**
 * 
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	//Derived Queries
	//List<Product> findByProductName (String productName);
	// Select * from products where name = ?
	
	List<Product> findByProductPriceGreaterThan(BigDecimal productPrice);
	// Select * from products where price > ?
	
	List<Product> findByDescriptionContaining(String keyword);
	// Select * from products where description like %keyword%
	
	List<Product> findByProductPriceAndProductName(BigDecimal productPrice, String productName );
	
	// JPQL Queries
	@Query("SELECT p FROM Product p WHERE p.productPrice > :productPrice") // ?1
	List<Product> findExpensiveProducts(@Param("productPrice") BigDecimal price);

	// Native Queries
	@Query(value = "SELECT * FROM tbl_product_master WHERE productName = :productName", nativeQuery = true)
	List<Product> findByNameNative(@Param("productName") String name);

	List<ProductView> findByProductName (String productName);
	// Select * from products where name = ?
}
