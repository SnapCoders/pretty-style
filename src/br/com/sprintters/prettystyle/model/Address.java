package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Address extends Entity {
	private String recipient;
	private String place;
	private String number;
	private String neighborhood;
	private String city;
	private String country;
	private String zip;
	private String complement;
	
	private int idUser;
	private User user;
	
	private UserAddress userAddress;
	
	public Address() { }
	
	public Address(String recipient, String place, String number, String neighborhood, String city, String country, String zip, String complement, int idUser) {
		this.recipient = recipient;
		this.place = place;
		this.number = number;
		this.neighborhood = neighborhood;
		this.city = city;
		this.country = country;
		this.zip = zip;
		this.complement = complement;
		this.idUser = idUser;
	}
	
	public Address(String recipient, String place, String number, String neighborhood, String city, String country, String zip, String complement, User user) {
		this.recipient = recipient;
		this.place = place;
		this.number = number;
		this.neighborhood = neighborhood;
		this.city = city;
		this.country = country;
		this.zip = zip;
		this.complement = complement;
		this.idUser = user.getId();
		this.user = user;
	}
	
	public Address(int id, String recipient, String place, String number, String neighborhood, String city, String country, String zip, String complement, int idUser) {
		super(id);
		this.recipient = recipient;
		this.place = place;
		this.number = number;
		this.neighborhood = neighborhood;
		this.city = city;
		this.country = country;
		this.zip = zip;
		this.complement = complement;
		this.idUser = idUser;
	}
	
	public Address(int id, String recipient, String place, String number, String neighborhood, String city, String country, String zip, String complement, User user) {
		super(id);
		this.recipient = recipient;
		this.place = place;
		this.number = number;
		this.neighborhood = neighborhood;
		this.city = city;
		this.country = country;
		this.zip = zip;
		this.complement = complement;
		this.idUser = user.getId();
		this.user = user;
	}
	
	public Address(int id, String recipient, String place, String number, String neighborhood, String city, String country, String zip, String complement, int idUser, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.recipient = recipient;
		this.place = place;
		this.number = number;
		this.neighborhood = neighborhood;
		this.city = city;
		this.country = country;
		this.zip = zip;
		this.complement = complement;
		this.idUser = idUser;
	}
	
	public Address(int id, String recipient, String place, String number, String neighborhood, String city, String country, String zip, String complement, User user, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.recipient = recipient;
		this.place = place;
		this.number = number;
		this.neighborhood = neighborhood;
		this.city = city;
		this.country = country;
		this.zip = zip;
		this.complement = complement;
		this.idUser = user.getId();
		this.user = user;
	}
	
	public String getRecipient() {
		return recipient;
	}
	
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
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
	
	public UserAddress getUserAddress() {
		return userAddress;
	}
	
	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}
	
	@Override
	public String toString() {
		return "Address [place=" + place + ", number=" + number + ", neighborhood=" + neighborhood + ", city=" + city
				+ ", country=" + country + ", zip=" + zip + ", complement=" + complement + ", idUser=" + idUser
				+ ", user=" + user + "]";
	}
}
