package com.ApiRestCrud.ApiRestCrud.services;

import com.ApiRestCrud.ApiRestCrud.entity.StudentEntity;

import java.util.List;
import java.util.Optional;

public interface StudentServices {
	List<StudentEntity> findAllStudents();
	Optional<StudentEntity> findByDni(String dni);
	StudentEntity saveStudent(StudentEntity student);
	StudentEntity updateStudent(StudentEntity student);
	void deleteStudent(String dni);
}
