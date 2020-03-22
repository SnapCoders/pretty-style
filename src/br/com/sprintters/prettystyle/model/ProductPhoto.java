package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class ProductPhoto extends Entity {
	private String name;
	private String url;
	
	private int idProduct;
	private Product product;

	public ProductPhoto() { }

	public ProductPhoto(String name, String url, Product product) {
		this.name = name;
		this.url = url;
		this.idProduct = product.getId();
		this.product = product;
	}
	
	public ProductPhoto(int id, String name, String url, Product product) {
		super(id);
		this.name = name;
		this.url = url;
		this.idProduct = product.getId();
		this.product = product;
	}
	
	public ProductPhoto(int id, String name, String url, Product product, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.name = name;
		this.url = url;
		this.idProduct = product.getId();
		this.product = product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	@Override
	public String toString() {
		return "ProductPhoto [name=" + name + ", url=" + url + ", idProduct=" + idProduct + ", product=" + product + "]";
	}
}
