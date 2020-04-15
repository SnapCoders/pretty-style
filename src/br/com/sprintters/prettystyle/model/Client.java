package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;
import java.util.Date;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Client extends Entity {
	private String name;
	private String surname;
	private String cpf;
	private Date birthday;
	private String sex;
	
	private int idUser;
	private User user;

	public Client() { }
	
	public Client(String name, String surname, String cpf, Date birthday, String sex) {
		this.name = name;
		this.surname = surname;
		this.cpf = cpf;
		this.birthday = birthday;
		this.sex = sex;
	}

	public Client(String name, String surname, String cpf, Date birthday, String sex, int idUser) {
		this.name = name;
		this.surname = surname;
		this.cpf = cpf;
		this.birthday = birthday;
		this.sex = sex;
		this.idUser = idUser;
	}
	
	public Client(String name, String surname, String cpf, Date birthday, String sex, User user) {
		this.name = name;
		this.surname = surname;
		this.cpf = cpf;
		this.birthday = birthday;
		this.sex = sex;
		this.idUser = user.getId();
		this.user = user;
	}
	
	public Client(int id, String name, String surname, String cpf, Date birthday, String sex, int idUser) {
		super(id);
		this.name = name;
		this.surname = surname;
		this.cpf = cpf;
		this.birthday = birthday;
		this.sex = sex;
		this.idUser = idUser;
	}
	
	public Client(int id, String name, String surname, String cpf, Date birthday, String sex, User user) {
		super(id);
		this.name = name;
		this.surname = surname;
		this.cpf = cpf;
		this.birthday = birthday;
		this.sex = sex;
		this.idUser = user.getId();
		this.user = user;
	}
	
	public Client(int id, String name, String surname, String cpf, Date birthday, String sex, int idUser, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.name = name;
		this.surname = surname;
		this.cpf = cpf;
		this.birthday = birthday;
		this.sex = sex;
		this.idUser = idUser;
	}
	
	public Client(int id, String name, String surname, String cpf, Date birthday, String sex, User user, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.name = name;
		this.surname = surname;
		this.cpf = cpf;
		this.birthday = birthday;
		this.sex = sex;
		this.idUser = user.getId();
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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
		return "Client [name=" + name + ", surname=" + surname + ", cpf=" + cpf + ", birthday=" + birthday + ", sex=" + sex + ", idUser=" + idUser + ", user=" + user + "]";
	}
}
