package com.ApiRestCrud.ApiRestCrud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "student")
public class StudentEntity {

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private String id;

	@Column(name = "full_name")
     private String fullName;

	@Column(name = "dni", length = 8)
	private String dni;

	@Column(name = "state")
     private boolean state;

	public StudentEntity() {
		this.id = UUID.randomUUID().toString();
	}

	public StudentEntity(String fullName, String dni, boolean state) {
		this();
		this.fullName = fullName;
		this.dni = dni;
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

}
