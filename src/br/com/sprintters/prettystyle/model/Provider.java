package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Provider extends Entity{
	private String cnpj;

	public Provider() { }

	public Provider(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public Provider(int id, String cnpj) {
		super(id);
		this.cnpj = cnpj;
	}
	
	public Provider(int id, String cnpj, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "Provider [cnpj=" + cnpj + "]";
	}
}
