package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Request extends Entity {
	private int idClient;
	private String numberRequest;
	
	private Client client;
	private Product product;
	
	private double totalPrice;
	
	public Request() { }

	public Request(int idClient, double totalPrice) {
		this.idClient = idClient;
		this.totalPrice = totalPrice;
	}
	
	public Request(Client client, double totalPrice) {
		this.idClient = client.getId();
		this.client = client;
		this.totalPrice = totalPrice;
	}
	
	public Request(Product product, int idClient) {
		this.idClient = idClient;
		this.product = product;		
	}
	
	public Request(int id, int idClient, double totalPrice) {
		super(id);
		this.idClient = idClient;
		this.totalPrice = totalPrice;
	}
	
	public Request(int id, Client client, double totalPrice) {
		super(id);
		this.idClient = client.getId();
		this.client = client;
		this.totalPrice = totalPrice;
	}
	
	public Request(int id, int idClient, double totalPrice, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.idClient = idClient;
		this.totalPrice = totalPrice;
	}
	
	public Request(int id, Client client, double totalPrice, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.idClient = client.getId();
		this.client = client;
		this.totalPrice = totalPrice;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	
	public String getNumberRequest() {
		return numberRequest;
	}

	public void setNumberRequest(String numberRequest) {
		this.numberRequest = numberRequest;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Request [idClient=" + idClient + ", numberRequest=" + numberRequest + ", client=" + client + ", product=" + product + ", totalPrice=" + totalPrice + "]";
	}
}
