package com.ApiRestCrud.ApiRestCrud.Services.Implementation;

import com.ApiRestCrud.ApiRestCrud.Entity.StudentEntity;
import com.ApiRestCrud.ApiRestCrud.Repositories.StudentRepository;
import com.ApiRestCrud.ApiRestCrud.Services.StudentServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServicesImp implements StudentServices {
	private final StudentRepository studentRepository;

	public StudentServicesImp(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}


	@Override
	public List<StudentEntity> findAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<StudentEntity> findStudentById(Long id) {
		return studentRepository.findById(id);
	}

	@Override
	public StudentEntity saveStudent(StudentEntity student) {
		return studentRepository.save(student);
	}

	@Override
	public StudentEntity updateStudent(Long id, StudentEntity student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
}
