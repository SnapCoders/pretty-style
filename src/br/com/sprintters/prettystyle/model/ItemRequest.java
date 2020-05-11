package br.com.sprintters.prettystyle.model;

public class ItemRequest {
	private int idItem;
	private int idRequest;
	
	
	public ItemRequest() {
	}
	
	public ItemRequest(int idItem, int idRequest) {
		this.idItem = idItem;
		this.idRequest = idRequest;
	}


	public int getIdItem() {
		return idItem;
	}


	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}


	public int getIdRequest() {
		return idRequest;
	}


	public void setIdRequest(int idRequest) {
		this.idRequest = idRequest;
	}
	
	
}
