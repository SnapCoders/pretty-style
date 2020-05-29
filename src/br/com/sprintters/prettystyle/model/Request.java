package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;
import java.util.ArrayList;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Request extends Entity {
	private int idClient;
	private String numberRequest;
	private String typePayment;
	
	private Client client;
	
	private ArrayList<Item> items;
	
	private double totalPrice;
	private double freight;
	
	public Request() { }

	public Request(int idClient, String numberRequest, String typePayment) {
		this.idClient = idClient;
		this.numberRequest = numberRequest;
		this.typePayment = typePayment;
	}
	
	public Request(int idClient, double totalPrice, double freight, String numberRequest, String typePayment) {
		this.idClient = idClient;
		this.totalPrice = totalPrice;
		this.freight = freight;
		this.numberRequest = numberRequest;
		this.typePayment = typePayment;
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
	

	public Request(int id,int idClient, String numberRequest, String typePayment, Client client, double totalPrice) {
		super(id);
		this.idClient = idClient;
		this.numberRequest = numberRequest;
		this.typePayment = typePayment;
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

	public String getTypePayment() {
		return typePayment;
	}

	public void setTypePayment(String typePayment) {
		this.typePayment = typePayment;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public double getFreight() {
		return freight;
	}
	
	public void setFreight(double freight) {
		this.freight = freight;
	}

	@Override
	public String toString() {
		return "Request [idClient=" + idClient + ", numberRequest=" + numberRequest + ", client=" + client + ", totalPrice=" + totalPrice + "]";
	}
}
