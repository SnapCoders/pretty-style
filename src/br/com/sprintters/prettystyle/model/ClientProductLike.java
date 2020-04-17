package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class ClientProductLike extends Entity {
	private int action;
	private int idProduct;	
	private int idClient;
	
	

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
}
