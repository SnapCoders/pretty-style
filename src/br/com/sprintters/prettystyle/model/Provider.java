package br.com.sprintters.prettystyle.model;

import java.sql.Timestamp;

import br.com.sprintters.prettystyle.model.generic.Entity;

public class Provider extends Entity {
	private String cnpj;
	private String fantasyName;
	private String socialReason;
	private String contact;
	
	private int idUser;
	private User user;

	public Provider() { }
	
	public Provider(String cnpj, String fantasyName, String socialReason, String contact) {
		this.cnpj = cnpj;
		this.fantasyName = fantasyName;
		this.socialReason = socialReason;
		this.contact = contact;
	}

	public Provider(String cnpj, String fantasyName, String socialReason, String contact, int idUser) {
		this.cnpj = cnpj;
		this.fantasyName = fantasyName;
		this.socialReason = socialReason;
		this.contact = contact;
		this.idUser = idUser;
	}
	
	public Provider(String cnpj, String fantasyName, String socialReason, String contact, User user) {
		this.cnpj = cnpj;
		this.fantasyName = fantasyName;
		this.socialReason = socialReason;
		this.contact = contact;
		this.idUser = user.getId();
		this.user = user;
	}
	
	public Provider(int id, String cnpj, String fantasyName, String socialReason, String contact, int idUser) {
		super(id);
		this.cnpj = cnpj;
		this.fantasyName = fantasyName;
		this.socialReason = socialReason;
		this.contact = contact;
		this.idUser = idUser;
	}
	
	public Provider(int id, String cnpj, String fantasyName, String socialReason, String contact, User user) {
		super(id);
		this.cnpj = cnpj;
		this.fantasyName = fantasyName;
		this.socialReason = socialReason;
		this.contact = contact;
		this.idUser = user.getId();
		this.user = user;
	}
	
	public Provider(int id, String cnpj, String fantasyName, String socialReason, String contact, int idUser, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.cnpj = cnpj;
		this.fantasyName = fantasyName;
		this.socialReason = socialReason;
		this.contact = contact;
		this.idUser = idUser;
	}
	
	public Provider(int id, String cnpj, String fantasyName, String socialReason, String contact, User user, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.cnpj = cnpj;
		this.fantasyName = fantasyName;
		this.socialReason = socialReason;
		this.contact = contact;
		this.idUser = user.getId();
		this.user = user;
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	public String getSocialReason() {
		return socialReason;
	}

	public void setSocialReason(String socialReason) {
		this.socialReason = socialReason;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
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
		return "Provider [cnpj=" + cnpj + ", idUser=" + idUser + ", user=" + user + "]";
	}
}
