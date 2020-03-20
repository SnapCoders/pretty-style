package br.com.sprintters.prettystyle.model.generic;

import java.sql.Timestamp;

public abstract class Entity {
	private int id;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private Timestamp deletedAt;
	
	
	
	public Entity() {
		
	}
	
	public Entity(int id, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}


	public Entity(int id) {
		this.id = id;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the createdAt
	 */
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * @return the updatedAt
	 */
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	/**
	 * @return the deletedAt
	 */
	public Timestamp getDeletedAt() {
		return deletedAt;
	}
	/**
	 * @param deletedAt the deletedAt to set
	 */
	public void setDeletedAt(Timestamp deletedAt) {
		this.deletedAt = deletedAt;
	}

}
