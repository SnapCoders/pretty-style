package br.com.sprintters.prettystyle.model;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Provider extends Entity{
	private String cnpj;

	public Provider() {
		super();
	}

	public Provider(String cnpj) {
		super();
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
