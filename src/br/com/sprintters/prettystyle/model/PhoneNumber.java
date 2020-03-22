package br.com.sprintters.prettystyle.model;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class PhoneNumber extends Entity {
	
	private int ddd;
	private String number;
	
	public PhoneNumber() {
		super();
	}

	public PhoneNumber(int ddd, String number) {
		super();
		this.ddd = ddd;
		this.number = number;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "PhoneNumber [ddd=" + ddd + ", number=" + number + "]";
	}
	
	
	

}
