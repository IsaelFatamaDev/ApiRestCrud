package com.ApiRestCrud.ApiRestCrud.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "full_name")
     private String fullName;

	@Column(name = "dni", length = 8)
	private String dni;

	@Column(name = "state")
     private boolean state;

	public StudentEntity() {
	}

	public StudentEntity(Long id, String fullName, String dni, boolean state) {
		this.id = id;
		this.fullName = fullName;
		this.dni = dni;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
