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

	@Lob
	@Column(name = "image_data")
	private byte[] imageData;

	@ManyToOne
	@JoinColumn(name = "id_student")
	private StudentEntity StudentEntity;

	public QrEntity() {
		this.id = UUID.randomUUID().toString();
	}
	public QrEntity(String id, String nameQr, boolean state, byte[] imageData, com.ApiRestCrud.ApiRestCrud.entity.StudentEntity studentEntity) {
		this();
		this.nameQr = nameQr;
		this.state = state;
		this.imageData = imageData;
		StudentEntity = studentEntity;
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

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public com.ApiRestCrud.ApiRestCrud.entity.StudentEntity getStudentEntity() {
		return StudentEntity;
	}

	public void setStudentEntity(com.ApiRestCrud.ApiRestCrud.entity.StudentEntity studentEntity) {
		StudentEntity = studentEntity;
	}
}
