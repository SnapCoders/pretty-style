package br.com.sprintters.prettystyle.model;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Address extends Entity{
	private String place;
	private String number;
	private String neighborhood;
	private String city;
	private String country;
	private String zip;
	private String complement;
	
	
	public Address() {
		super();
	}


	public Address(String place, String number, String neighborhood, String city, String country, String zip,
			String complement) {
		super();
		this.place = place;
		this.number = number;
		this.neighborhood = neighborhood;
		this.city = city;
		this.country = country;
		this.zip = zip;
		this.complement = complement;
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


	@Override
	public String toString() {
		return "Address [place=" + place + ", number=" + number + ", neighborhood=" + neighborhood + ", city=" + city
				+ ", country=" + country + ", zip=" + zip + ", complement=" + complement + "]";
	}
	
	
	
	

}
