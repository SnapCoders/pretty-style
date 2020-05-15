package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Category extends Entity {
	private String name;
	
	private int idProvider;
	private Provider provider;

	public Category() { }
	
	public Category(int id) {
		super(id);
	}

	public Category(String name, int idProvider) {
		this.name = name;
		this.idProvider = idProvider;
	}
	
	public Category(int id, String name) {
		super(id);
		this.name = name;
	}
	
	public Category(int id, String name, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getIdProvider() {
		return idProvider;
	}

	public void setIdProvider(int idProvider) {
		this.idProvider = idProvider;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	@Override
	public String toString() {
		return super.getId()+","+name;
	}
}
