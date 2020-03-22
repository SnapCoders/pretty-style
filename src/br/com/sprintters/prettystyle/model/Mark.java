package br.com.sprintters.prettystyle.model;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Mark extends Entity{
	private String name;

	public Mark() {
		super();
	}

	public Mark(String name) {
		super();
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
