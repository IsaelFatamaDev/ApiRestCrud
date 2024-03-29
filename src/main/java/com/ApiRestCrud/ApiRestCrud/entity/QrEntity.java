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
	@JoinColumn(name = "id_assignment_student")
	private AssignmentStudentEntity assignmentStudent;

	public QrEntity() {
		this.id = UUID.randomUUID().toString();
	}

	public QrEntity(String nameQr, boolean state, AssignmentStudentEntity assignmentStudent) {
		this.nameQr = nameQr;
		this.state = state;
		this.assignmentStudent = assignmentStudent;
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

	public AssignmentStudentEntity getAssignmentStudent() {
		return assignmentStudent;
	}

	public void setAssignmentStudent(AssignmentStudentEntity assignmentStudent) {
		this.assignmentStudent = assignmentStudent;
	}
}
