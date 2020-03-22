package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Category extends Entity {
	private String name;
	private String color;
	
	public Category() { }

	public Category(String name, String color) {
		this.name = name;
		this.color = color;
	}
	
	public Category(int id, String name, String color) {
		super(id);
		this.name = name;
		this.color = color;
	}
	
	public Category(int id, String name, String color, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + ", color=" + color + "]";
	}
}
