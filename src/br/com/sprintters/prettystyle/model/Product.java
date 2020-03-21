package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Product extends Entity{
	private String name;
	private String description;
	private double price;
	
	
	public Product() {
		super();
	}


	public Product(String name, String description, double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public Product (int id, String name, String description, double price, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt,updatedAt, deletedAt);
		this.name = name;
		this.description = description;
		this.price = price;
		
	}
	public Product(int id, String name, String description, double price) {
		super(id);
		this.name = name;
		this.description = description;
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", price=" + price + "]";
	}
	
}
