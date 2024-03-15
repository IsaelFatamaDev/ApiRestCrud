package com.ApiRestCrud.ApiRestCrud.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "assignment_student")
public class AssignmentStudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_teacher")
	private TeacherEntity teacher;

	@ManyToOne
	@JoinColumn(name = "id_student")
	private StudentEntity student;

	private int grade;
	private boolean state;

	public AssignmentStudentEntity() {
	}

	public AssignmentStudentEntity(TeacherEntity teacher, StudentEntity student, int grade, boolean state) {
		this.teacher = teacher;
		this.student = student;
		this.grade = grade;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TeacherEntity getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherEntity teacher) {
		this.teacher = teacher;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
