package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class PhoneNumber extends Entity {
	private int ddd;
	private String number;
	
	private int idUser;
	private User user;
	
	public PhoneNumber() { }

	public PhoneNumber(int ddd, String number, User user) {
		this.ddd = ddd;
		this.number = number;
		this.idUser = user.getId();
		this.user = user;
	}
	
	public PhoneNumber(int id, int ddd, String number, User user) {
		super(id);
		this.ddd = ddd;
		this.number = number;
		this.idUser = user.getId();
		this.user = user;
	}
	
	public PhoneNumber(int id, int ddd, String number, User user, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.ddd = ddd;
		this.number = number;
		this.idUser = user.getId();
		this.user = user;
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

	@Override
	public String toString() {
		return "PhoneNumber [ddd=" + ddd + ", number=" + number + ", idUser=" + idUser + ", user=" + user + "]";
	}
}
