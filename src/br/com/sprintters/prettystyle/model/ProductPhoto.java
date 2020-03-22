package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class ProductPhoto extends Entity {
	private String name;
	private String url;
	
	public ProductPhoto() { }

	public ProductPhoto(String name, String url) {
		this.name = name;
		this.url = url;
	}
	
	public ProductPhoto(int id, String name, String url) {
		super(id);
		this.name = name;
		this.url = url;
	}
	
	public ProductPhoto(int id, String name, String url, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.name = name;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ProductPhoto [name=" + name + ", url=" + url + "]";
	}
}
