package com.ApiRestCrud.ApiRestCrud.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "qr")
public class QrEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nameQr;
	private boolean state;
	@ManyToOne
	@JoinColumn(name = "id_assignment_student")
	private AssignmentStudentEntity assignmentStudent;

	public QrEntity() {
	}

	public QrEntity(String nameQr, boolean state, AssignmentStudentEntity assignmentStudent) {
		this.nameQr = nameQr;
		this.state = state;
		this.assignmentStudent = assignmentStudent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
