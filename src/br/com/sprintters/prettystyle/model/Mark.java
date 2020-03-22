package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Mark extends Entity {
	private String name;

	public Mark() { }

	public Mark(String name) {
		this.name = name;
	}
	
	public Mark(int id, String name) {
		super(id);
		this.name = name;
	}
	
	public Mark(int id, String name, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Mark [name=" + name + "]";
	}
}
