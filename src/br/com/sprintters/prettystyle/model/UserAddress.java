package br.com.sprintters.prettystyle.model;

public class UserAddress {
	private int idUser;
	private User user;
	
	private int idAddress;
	private Address address;
	
	public UserAddress() { }
	
	public UserAddress(int idUser, int idAdress) {
		this.idUser = idUser;
		this.idAddress = idAdress;
	}
	
	public int getIdUser() {
		return idUser;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getIdAddress() {
		return idAddress;
	}
	
	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
}
