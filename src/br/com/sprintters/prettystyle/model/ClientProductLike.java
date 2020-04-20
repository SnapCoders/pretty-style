package br.com.sprintters.prettystyle.model;

public class ClientProductLike {
	private int id;
	private int action;
	
	private int idProduct;
	private Product product;
	
	private int idClient;
	private Client client;

	public ClientProductLike() { }

	public ClientProductLike(int idClient, int idProduct, int action) {
		this.idProduct = idProduct;
		this.idClient = idClient;
		this.action = action;
	}
	
	public ClientProductLike(int id, int idClient, int idProduct, int action) {
		this.id = id;
		this.idProduct = idProduct;
		this.idClient = idClient;
		this.action = action;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

	@Override
	public String toString() {
		return "ClientProductLike [id=" + id + ", action=" + action + ", idProduct=" + idProduct + ", idClient=" + idClient + "]";
	}
}
