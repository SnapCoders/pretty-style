package br.com.sprintters.prettystyle.model.virtual;

import java.util.ArrayList;

import br.com.sprintters.prettystyle.model.Item;

public class Cart {
	private ArrayList<Item> items;
	private int quantity;
	private double total;
	private double totalItems;
	private double frete;
	private double bankSlip;
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(double totalItems) {
		this.totalItems = totalItems;
	}

	public double getFrete() {
		return frete;
	}

	public void setFrete(double frete) {
		this.frete = frete;
	}

	public double getBankSlip() {
		return bankSlip;
	}

	public void setBankSlip(double bankSlip) {
		this.bankSlip = bankSlip;
	}

	public Cart() {
		this.items = new ArrayList<Item>();
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
}
