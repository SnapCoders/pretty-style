package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

public class ProductCategory {
	private int idProduct;
	private Product product;
	
	private int idCategory;
	private Category category;
	
	private Timestamp createdAt;
	
	public ProductCategory() { }
	
	public ProductCategory(int idProduct, int idCategory) {
		this.idProduct = idProduct;
		this.idCategory = idCategory;
	}
	
	public ProductCategory(int idProduct, int idCategory, Timestamp createdAt) {
		this.idProduct = idProduct;
		this.idCategory = idCategory;
		this.createdAt = createdAt;
	}
	
	public int getIdProduct() {
		return idProduct;
	}
	
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}

	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public int getIdCategory() {
		return idCategory;
	}
	
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "ProductCategory [idProduct=" + idProduct + ", idCategory=" + idCategory + ", createdAt=" + createdAt + "]";
	}
}
