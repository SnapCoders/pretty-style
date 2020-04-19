package br.com.sprintters.prettystyle.model.virtual;

import java.util.ArrayList;

import br.com.sprintters.prettystyle.model.Item;

public class Cart {
	private ArrayList<Item> items;
	
	public Cart() {
		this.items = new ArrayList();
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
}
