package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Client extends Entity {
	private String cpf;

	public Client() { }

	public Client(String cpf) {
		this.cpf = cpf;
	}
	
	public Client(int id, String cpf) {
		super(id);
		this.cpf = cpf;
	}
	
	public Client(int id, String cpf, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Client [cpf=" + cpf + "]";
	}
}
