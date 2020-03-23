package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Request extends Entity {
	private int idClient;
	private Client client;
	
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Request [idClient=" + idClient + ", client=" + client + ", totalPrice=" + totalPrice + "]";
	}
}
