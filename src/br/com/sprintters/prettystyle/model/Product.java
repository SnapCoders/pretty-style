package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Product extends Entity {
	private String name;
	private String description;
	private double price;
	
	private int idMark;
	private Mark mark;
	
	public Product() { }

	public Product(String name, String description, double price, Mark mark) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.idMark = mark.getId();
		this.mark = mark;
	}
	
	public Product(int id, String name, String description, double price, Mark mark) {
		super(id);
		this.name = name;
		this.description = description;
		this.price = price;
		this.idMark = mark.getId();
		this.mark = mark;
	}
	
	public Product (int id, String name, String description, double price, Mark mark, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt,updatedAt, deletedAt);
		this.name = name;
		this.description = description;
		this.price = price;
		this.idMark = mark.getId();
		this.mark = mark;
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

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getIdMark() {
		return idMark;
	}
	
	public void setIdMark(int idMark) {
		this.idMark = idMark;
	}
	
	public Mark getMark() {
		return mark;
	}
	
	public void setMark(Mark mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", price=" + price + ", idMark=" + idMark + "]";
	}
}
