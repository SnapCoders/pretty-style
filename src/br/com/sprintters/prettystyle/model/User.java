package br.com.sprintters.prettystyle.model;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class User extends Entity {
	private String username;
	private String name;
	private String surname;
	private String email;
	private int ddd;
	private String cpf;
	private String number;
	private String emailConfirmation;
	private String passwordHash;
	private Date birthday;
	private String sex;
	private ArrayList<PhoneNumber> phoneNumbers;
	
	private Client client;
	private Provider provider;
	private PhoneNumber pn;
	
	private String password;
	private boolean signed;
	private boolean isProvider;
	
	public User() { }
	
	public User(String name, String surname, String email) {
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	public User(String username, String name, String surname, String email, String emailConfirmation, String sex, 
			Date birthday, int ddd, String number, String cpf) {
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.emailConfirmation = emailConfirmation;
		this.birthday = birthday;
		this.sex = sex;
		this.ddd = ddd;
		this.number = number;
		this.cpf = cpf;
	}
	
	public User(String username, String name, String surname, String email, String emailConfirmation, Date birthday, String sex) {
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.emailConfirmation = emailConfirmation;
		this.birthday = birthday;
		this.sex = sex;
	}
	
	public User(int id, String username, String name, String surname, String email, String emailConfirmation, Date birthday, String sex) {
		super(id);
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.emailConfirmation = emailConfirmation;
		this.birthday = birthday;
		this.sex = sex;

	}
	
	public User(int id, String username, String name, String surname, String email, String emailConfirmation, Date birthday, String sex, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.emailConfirmation = emailConfirmation;
		this.birthday = birthday;
		this.sex = sex;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailConfirmation() {
		return emailConfirmation;
	}

	public void setEmailConfirmation(String emailConfirmation) {
		this.emailConfirmation = emailConfirmation;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
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

	public ArrayList<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(ArrayList<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSigned() {
		return signed;
	}

	public void setSigned(boolean signed) {
		this.signed = signed;
	}

	public boolean isProvider() {
		if (this.client == null && this.provider != null) {
			this.isProvider = false;
		} else if (this.client != null && this.provider == null) {
			this.isProvider = true;
		}
		
		return isProvider;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", email=" + email + "]";
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public PhoneNumber getPn() {
		return pn;
	}

	public void setPn(PhoneNumber pn) {
		this.pn = pn;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
