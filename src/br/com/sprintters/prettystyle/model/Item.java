package br.com.sprintters.prettystyle.model;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Item extends Entity {
	private int quantity;
	
	public Item() {
		super();
	}

	public Item(int quantity) {
		super();
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
