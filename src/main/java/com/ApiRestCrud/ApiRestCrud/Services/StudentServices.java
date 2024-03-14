package com.ApiRestCrud.ApiRestCrud.Services;

import com.ApiRestCrud.ApiRestCrud.Entity.StudentEntity;

import java.util.List;
import java.util.Optional;

public interface StudentServices {
	List<StudentEntity> findAllStudents();
	Optional<StudentEntity> findStudentById(Long id);
	StudentEntity saveStudent(StudentEntity student);
	StudentEntity updateStudent(Long id, StudentEntity student);
	void deleteStudent(Long id);
}
