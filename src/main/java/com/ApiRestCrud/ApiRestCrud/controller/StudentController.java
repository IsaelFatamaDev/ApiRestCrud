package com.ApiRestCrud.ApiRestCrud.controller;

import com.ApiRestCrud.ApiRestCrud.entity.StudentEntity;
import com.ApiRestCrud.ApiRestCrud.services.StudentServices;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;@RestController

@RequestMapping("/api/v1/students")
public class StudentController {
	private final StudentServices studentService;

	public StudentController(StudentServices studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public List<StudentEntity> findAllStudents() {
		return studentService.findAllStudents();
	}

	@GetMapping("/{dni}")
	public Optional<StudentEntity> findByDni(@PathVariable("dni") String dni) {
		return studentService.findByDni(dni);
	}

	@PostMapping
	public StudentEntity saveStudent(@RequestBody StudentEntity student) throws BadRequestException {
		Optional<StudentEntity> existingStudent = studentService.findByDni(student.getDni());
		if (existingStudent.isPresent()) {
			throw new BadRequestException("Ya existe un estudiante con el mismo DNI");
		}
		return studentService.saveStudent(student);
	}

	@PutMapping("/{dni}")
	public StudentEntity updateStudent(@PathVariable("dni") String dni, @RequestBody StudentEntity student) {
		return studentService.updateStudent(student);
	}

	@DeleteMapping("/{dni}")
	public void deleteStudent(@PathVariable("dni") String dni) {
		studentService.deleteStudent(dni);
	}
}
