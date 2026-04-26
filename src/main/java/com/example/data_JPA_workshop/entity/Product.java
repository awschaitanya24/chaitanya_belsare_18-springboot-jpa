/**
 * 
 */
package com.example.data_JPA_workshop.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

/**
 * 
 */
@Entity
@Table(name = "tbl_product_master")
public class Product {

	// TableName from db
	// ORM - Object Releation Mapping

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;

	@Column(name = "Product_Name", length = 50)
	private String productName;

	@Column(name = "Description", length = 500, nullable = false)
	private String description;
	
	@Column(name = "Product_Owner", length = 20)
	private String productOwner;

	@Min(100)
	@Column(name = "Product_Price", nullable = false, scale = 3, precision = 16)
	private BigDecimal productPrice;

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the productPrice
	 */
	public BigDecimal getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the productOwner
	 */
	public String getProductOwner() {
		return productOwner;
	}

	/**
	 * @param productOwner the productOwner to set
	 */
	public void setProductOwner(String productOwner) {
		this.productOwner = productOwner;
	}
}
