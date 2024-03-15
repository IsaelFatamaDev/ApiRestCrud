package com.ApiRestCrud.ApiRestCrud.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "agent")
public class AgentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

	@ManyToOne
	@JoinColumn(name = "id_student")
	private StudentEntity id_student;
	@Column(name = "numberPhone", length = 11)
	private String numberPhone;
	private boolean state;

	public AgentEntity() {
	}

	public AgentEntity(StudentEntity id_student, String numberPhone, boolean state) {
		this.id_student = id_student;
		this.numberPhone = numberPhone;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
