package com.ApiRestCrud.ApiRestCrud.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "agent")
public class AgentEntity {

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private String id;

	@ManyToOne
	@JoinColumn(name = "id_student")
	private StudentEntity id_student;
	@Column(name = "numberPhone", length = 11)
	private String numberPhone;
	private boolean state;

	public AgentEntity() {
		this.id = UUID.randomUUID().toString();
	}

	public AgentEntity(StudentEntity id_student, String numberPhone, boolean state) {
		this.id_student = id_student;
		this.numberPhone = numberPhone;
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public StudentEntity getId_student() {
		return id_student;
	}

	public void setId_student(StudentEntity id_student) {
		this.id_student = id_student;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
