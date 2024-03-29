package com.ApiRestCrud.ApiRestCrud.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "teacher")
public class TeacherEntity {
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private String id;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "email")
	private String email;

	@Column(name = "state")
	private boolean state;

	public TeacherEntity() {
		this.id = UUID.randomUUID().toString();
	}

	public TeacherEntity(String fullName, String email, boolean state) {
		this.fullName = fullName;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}

/*
* CREATE TABLE teacher (
    id int  NOT NULL,
    full_name varchar(50)  NOT NULL,
    email varchar(100)  NOT NULL,
    state boolean  NOT NULL,
    CONSTRAINT teacher_pk PRIMARY KEY (id)
);
* */