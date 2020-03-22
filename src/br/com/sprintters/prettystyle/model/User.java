package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class User extends Entity {
	private String name;
	private String surname;
	private String email;
	
	public User() { }

	public User(String name, String surname, String email) {
		this.name = name;
		this.surname = surname;
		this.email = email;
	}
	
	public User(int id, String name, String surname, String email) {
		super(id);
		this.name = name;
		this.surname = surname;
		this.email = email;
	}
	
	public User(int id, String name, String surname, String email, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.name = name;
		this.surname = surname;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", email=" + email + "]";
	}
}
