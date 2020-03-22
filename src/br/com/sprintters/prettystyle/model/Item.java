package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Item extends Entity {
	private int quantity;
	
	public Item() { }

	public Item(int quantity) {
		this.quantity = quantity;
	}

	public Item(int id, int quantity) {
		super(id);
		this.quantity = quantity;
	}
	
	public Item(int id, int quantity, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [quantity=" + quantity + "]";
	}
}
