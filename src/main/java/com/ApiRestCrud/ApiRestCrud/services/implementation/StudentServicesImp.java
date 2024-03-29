package com.ApiRestCrud.ApiRestCrud.services.implementation;

import com.ApiRestCrud.ApiRestCrud.entity.StudentEntity;
import com.ApiRestCrud.ApiRestCrud.repositories.StudentRepository;
import com.ApiRestCrud.ApiRestCrud.services.StudentServices;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
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
	public Optional<StudentEntity> findByDni(String dni) {
		return studentRepository.findByDni(dni);
	}

	@Override
	public StudentEntity saveStudent(StudentEntity student) {
		return studentRepository.save(student);
	}

	@Override
	public StudentEntity updateStudent(StudentEntity student) {
		Optional<StudentEntity> existingStudentOptional = studentRepository.findByDni(student.getDni());
		if (existingStudentOptional.isPresent()) {
			StudentEntity existingStudent = existingStudentOptional.get();
			existingStudent.setFullName(student.getFullName());
			existingStudent.setDni(student.getDni());
			existingStudent.setState(student.isState());
			return studentRepository.save(existingStudent);
		} else {
			// Manejar el caso en el que el estudiante no exista
			throw new IllegalArgumentException("No se puede actualizar el estudiante. El estudiante con DNI " + student.getDni() + " no existe.");
		}
	}

	@Override
	public void deleteStudent(String dni) {
		studentRepository.deleteByDni(dni);
	}
}
