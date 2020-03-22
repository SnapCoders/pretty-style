package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Client extends Entity {
	private String cpf;
	
	private int idUser;
	private User user;

	public Client() { }

	public Client(String cpf, User user) {
		this.cpf = cpf;
		this.idUser = user.getId();
		this.user = user;
	}
	
	public Client(int id, String cpf, User user) {
		super(id);
		this.cpf = cpf;
		this.idUser = user.getId();
		this.user = user;
	}
	
	public Client(int id, String cpf, User user, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.cpf = cpf;
		this.idUser = user.getId();
		this.user = user;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
		return "Client [cpf=" + cpf + ", idUser=" + idUser + ", user=" + user + "]";
	}
}
