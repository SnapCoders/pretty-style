package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Address extends Entity {
	private String place;
	private String number;
	private String neighborhood;
	private String city;
	private String country;
	private String zip;
	private String complement;
	
	private int idUser;
	private String name;
	private String surname;
	private User user;
	
	public Address() { }
	
	public Address(String place, String number, String neighborhood, String city, String country, String zip, String complement, int idUser) {
		this.place = place;
		this.number = number;
		this.neighborhood = neighborhood;
		this.city = city;
		this.country = country;
		this.zip = zip;
		this.complement = complement;
		this.idUser = idUser;
	}
	
	public Address(String place, String number, String neighborhood, String city, String country, String zip, 
			String complement, int idUser, String name, String surname) {
		this.place = place;
		this.number = number;
		this.neighborhood = neighborhood;
		this.city = city;
		this.country = country;
		this.zip = zip;
		this.complement = complement;
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
	}
	
	public Address(String place, String number, String neighborhood, String city, String country, String zip, String complement, User user) {
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
	
	public Address(int id, String place, String number, String neighborhood, String city, String country, String zip, String complement, int idUser) {
		super(id);
		this.place = place;
		this.number = number;
		this.neighborhood = neighborhood;
		this.city = city;
		this.country = country;
		this.zip = zip;
		this.complement = complement;
		this.idUser = idUser;
	}
	
	public Address(int id, String place, String number, String neighborhood, String city, String country, String zip, String complement, User user) {
		super(id);
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
	
	public Address(int id, String place, String number, String neighborhood, String city, String country, String zip, String complement, int idUser, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.place = place;
		this.number = number;
		this.neighborhood = neighborhood;
		this.city = city;
		this.country = country;
		this.zip = zip;
		this.complement = complement;
		this.idUser = idUser;
	}
	
	public Address(int id, String place, String number, String neighborhood, String city, String country, String zip, String complement, User user, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Override
	public String toString() {
		return "Address [place=" + place + ", number=" + number + ", neighborhood=" + neighborhood + ", city=" + city
				+ ", country=" + country + ", zip=" + zip + ", complement=" + complement + ", idUser=" + idUser
				+ ", user=" + user + "]";
	}


}
