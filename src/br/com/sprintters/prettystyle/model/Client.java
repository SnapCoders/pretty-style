package br.com.sprintters.prettystyle.model;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Client extends Entity {
	
	private String cpf;

	public Client() {
		super();
	}

	public Client(String cpf) {
		super();
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
