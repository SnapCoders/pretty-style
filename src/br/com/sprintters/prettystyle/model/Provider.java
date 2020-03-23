package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Provider extends Entity {
	private String cnpj;
	
	private int idUser;
	private User user;

	public Provider() { }

	public Provider(String cnpj, int idUser) {
		this.cnpj = cnpj;
		this.idUser = idUser;
	}
	
	public Provider(String cnpj, User user) {
		this.cnpj = cnpj;
		this.idUser = user.getId();
		this.user = user;
	}
	
	public Provider(int id, String cnpj, int idUser) {
		super(id);
		this.cnpj = cnpj;
		this.idUser = idUser;
	}
	
	public Provider(int id, String cnpj, User user) {
		super(id);
		this.cnpj = cnpj;
		this.idUser = user.getId();
		this.user = user;
	}
	
	public Provider(int id, String cnpj, int idUser, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.cnpj = cnpj;
		this.idUser = idUser;
	}
	
	public Provider(int id, String cnpj, User user, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.cnpj = cnpj;
		this.idUser = user.getId();
		this.user = user;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
		return "Provider [cnpj=" + cnpj + ", idUser=" + idUser + ", user=" + user + "]";
	}
}
