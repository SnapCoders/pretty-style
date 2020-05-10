package br.com.sprintters.prettystyle.model;

import java.util.ArrayList;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Stock extends Entity{
	private int quantity;
	
	private ArrayList<Product> product;
	
	
	public Stock() {
		super();
	}

	public Stock(int quantity) {
		super();
		this.quantity = quantity;
	}
	
	public Stock(int id, int quantity) {
		super(id);
		this.quantity = quantity;
	}
	
	public Stock(int id, int quantity, ArrayList<Product> product) {
		super(id);
		this.quantity = quantity;
		this.product = product;
	}
	
	public Stock(int quantity, ArrayList<Product> product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ArrayList<Product> getProduct() {
		return product;
	}

	public void setProduct(ArrayList<Product> product) {
		this.product = product;
	}
	
	
}