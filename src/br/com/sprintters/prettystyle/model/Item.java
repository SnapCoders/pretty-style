package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Item extends Entity {
	private int quantity;
	private String name;
	private String description;
	private int price;
	
	private int idProduct;
	private Product product;
	
	private int idRequest;
	private Request request;

	public Item() { }

	public Item(int quantity, int idProduct, int idRequest) {
		this.quantity = quantity;
		this.idProduct = idProduct;
		this.idRequest = idRequest;
	}
	
	public Item(int quantity, Product product, Request request) {
		this.quantity = quantity;
		this.idProduct = product.getId();
		this.product = product;
		this.idRequest = request.getId();
		this.request = request;
	}
	
	public Item(int quantity, String name, String description, int price ) {
		this.quantity = quantity;
		this.setName(name);
		this.setDescription(description);
		this.setPrice(price);

	}
	
	public Item(int id, int quantity, int idProduct, int idRequest) {
		super(id);
		this.quantity = quantity;
		this.idProduct = idProduct;
		this.idRequest = idRequest;
	}

	public Item(int id, int quantity, Product product, Request request) {
		super(id);
		this.quantity = quantity;
		this.idProduct = product.getId();
		this.product = product;
		this.idRequest = request.getId();
		this.request = request;
	}
	
	public Item(int id, int quantity, int idProduct, int idRequest, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.quantity = quantity;
		this.idProduct = idProduct;
		this.idRequest = idRequest;
	}
	
	public Item(int id, int quantity, Product product, Request request, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.quantity = quantity;
		this.idProduct = product.getId();
		this.product = product;
		this.idRequest = request.getId();
		this.request = request;
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
	
	public int getIdRequest() {
		return idRequest;
	}

	public void setIdRequest(int idRequest) {
		this.idRequest = idRequest;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	@Override
	public String toString() {
		return "Item [quantity=" + quantity + ", idProduct=" + idProduct + ", product=" + product + ", idRequest="
				+ idRequest + ", request=" + request + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
