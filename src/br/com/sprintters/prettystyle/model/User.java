package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;
import java.util.ArrayList;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class User extends Entity {
	private String username;
	private String email;
	private String emailConfirmation;
	private String passwordHash;
	private ArrayList<PhoneNumber> phoneNumbers;
	private ArrayList<Address> addresses;
	
	private Client client;
	private Provider provider;
	private UserAddress userAddress;
	
	private String password;
	private boolean signed;
	private boolean isProvider;
	
	public User() { }
	
	public User(String username, String email) {
		this.username = username;
		this.email = email;
	}
	
	public User(String username, String email, String emailConfirmation) {
		this.username = username;this.email = email;
		this.emailConfirmation = emailConfirmation;
	}
	
	public User(int id, String username, String name, String surname, String email, String emailConfirmation) {
		super(id);
		this.username = username;
		this.email = email;
		this.emailConfirmation = emailConfirmation;
	}
	
	public User(int id, String username, String email, String emailConfirmation, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.username = username;
		this.email = email;
		this.emailConfirmation = emailConfirmation;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public ArrayList<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(ArrayList<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	public ArrayList<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(ArrayList<Address> addresses) {
		this.addresses = addresses;
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
	
	public UserAddress getUserAddress() {
		return userAddress;
	}
	
	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
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
		return "User [username=" + username + ", email=" + email + "]";
	}
}
