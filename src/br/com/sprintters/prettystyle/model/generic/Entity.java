package br.com.sprintters.prettystyle.model.generic;

import java.sql.Timestamp;

public abstract class Entity {
	private int id;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private Timestamp deletedAt;
	
	public Entity() { }
	
	public Entity(int id, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	
	public Entity(Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	public Entity(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Timestamp getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Timestamp deletedAt) {
		this.deletedAt = deletedAt;
	}
	
	@Override
	public String toString() {
		return "Entity [id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + "]";
	}
}
