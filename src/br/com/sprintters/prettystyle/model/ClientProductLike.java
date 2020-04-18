package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class ClientProductLike extends Entity {
	private int action;
	private int idProduct;	
	private int idClient;
	private String name;
	private String description;
	private int price;
	
	

	public ClientProductLike() { }

	public ClientProductLike(int idClient, int idProduct, int action,
			Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(createdAt, updatedAt, deletedAt);
		this.idProduct = idProduct;
		this.idClient = idClient;
		this.action = action;
	}
	
	public ClientProductLike(int idClient, int idProduct, int action) {
		
		this.idProduct = idProduct;
		this.idClient = idClient;
		this.action = action;
	}
	
	public ClientProductLike(String name, String description, int price, int action) {
		this.setName(name);
		this.setDescription(description);
		this.setPrice(price);
		this.setPrice(action);

	}
	
	
	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	@Override
	public String toString() {
		return "ClientProductLike [idProduct=" + idProduct + "]";
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
