package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Item extends Entity {
	private int quantity;
	
	private int idProduct;
	private Product product;
	
	private int idClient;
	private Client client;

	public Item() { }

	public Item(int quantity, int idProduct, int idClient) {
		this.quantity = quantity;
		this.idProduct = idProduct;
		this.idClient = idClient;
	}
	
	public Item(int quantity, Product product, Client client) {
		this.quantity = quantity;
		this.idProduct = product.getId();
		this.product = product;
		this.idClient = client.getId();
		this.client = client;
	}
	
	public Item(int id, int quantity, int idProduct, int idClient) {
		super(id);
		this.quantity = quantity;
		this.idProduct = idProduct;
		this.idClient = idClient;
	}

	public Item(int id, int quantity, Product product, Client client) {
		super(id);
		this.quantity = quantity;
		this.idProduct = product.getId();
		this.product = product;
		this.idClient = client.getId();
		this.client = client;
	}
	
	public Item(int id, int quantity, int idProduct, int idClient, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.quantity = quantity;
		this.idProduct = idProduct;
		this.idClient = idClient;
	}
	
	public Item(int id, int quantity, Product product, Client client, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.quantity = quantity;
		this.idProduct = product.getId();
		this.product = product;
		this.idClient = client.getId();
		this.client = client;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Item [quantity=" + quantity + ", idProduct=" + idProduct + ", product=" + product + ", idRequest=" + idClient + ", request=" + client + "]";
	}
}
