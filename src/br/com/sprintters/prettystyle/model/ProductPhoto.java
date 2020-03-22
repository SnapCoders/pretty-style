package br.com.sprintters.prettystyle.model;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class ProductPhoto extends Entity {
	
	private String name;
	private String url;
	
	public ProductPhoto() {
		super();
	}

	public ProductPhoto(String name, String url) {
		super();
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
