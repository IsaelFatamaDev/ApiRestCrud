package com.ApiRestCrud.ApiRestCrud.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "qr")
public class QrEntity {
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private String id;
	@Column(name = "name_qr")
	private String nameQr;
	@Column(name = "state")
	private boolean state;

	@Column(name = "image_data", columnDefinition = "TEXT")
	private String imageData;

	@ManyToOne
	@JoinColumn(name = "id_student")
	private StudentEntity studentEntity;

	public QrEntity() {
		this.id = UUID.randomUUID().toString();
	}

	public QrEntity(String id, String nameQr, boolean state, String imageData, StudentEntity studentEntity) {
		this();
		this.nameQr = nameQr;
		this.state = state;
		this.imageData = imageData;
		this.studentEntity = studentEntity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameQr() {
		return nameQr;
	}

	public void setNameQr(String nameQr) {
		this.nameQr = nameQr;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getImageData() {
		return imageData;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	public StudentEntity getStudentEntity() {
		return studentEntity;
	}

	public void setStudentEntity(StudentEntity studentEntity) {
		this.studentEntity = studentEntity;
	}
}
