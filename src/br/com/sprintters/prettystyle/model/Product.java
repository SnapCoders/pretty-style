package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;
import java.util.ArrayList;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Product extends Entity {
	private String name;
	private String description;
	private double price;
	
	private int idMark;
	private Mark mark;
	
	private int idProvider;
	private Provider provider;
	
	private ArrayList<ProductPhoto> photos;
	
	public Product() { }

	public Product(String name, String description, double price, int idMark, int idProvider) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.idMark = idMark;
		this.idProvider = idProvider;
	}
	
	public Product(String name, String description, double price, Mark mark) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.idMark = mark.getId();
		this.mark = mark;
	}
	
	public Product(int id, String name, String description, double price, int idMark) {
		super(id);
		this.name = name;
		this.description = description;
		this.price = price;
		this.idMark = idMark;
	}
	
	public Product(int id, String name, String description, double price, Mark mark) {
		super(id);
		this.name = name;
		this.description = description;
		this.price = price;
		this.idMark = mark.getId();
		this.mark = mark;
	}
	
	public Product (int id, String name, String description, double price, int idMark, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt,updatedAt, deletedAt);
		this.name = name;
		this.description = description;
		this.price = price;
		this.idMark = idMark;
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

	public ArrayList<ProductPhoto> getPhotos() {
		return photos;
	}

	public void setPhotos(ArrayList<ProductPhoto> photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", price=" + price + ", idMark=" + idMark + "]";
	}
}
