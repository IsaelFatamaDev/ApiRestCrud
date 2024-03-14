package com.ApiRestCrud.ApiRestCrud.Controller;

import com.ApiRestCrud.ApiRestCrud.Entity.StudentEntity;
import com.ApiRestCrud.ApiRestCrud.Services.StudentServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	private final StudentServices studentService;

	public StudentController(StudentServices studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/all")
	public List<StudentEntity> findAllStudents() {
          return studentService.findAllStudents();
     }

	@GetMapping("/{id}")
     public Optional<StudentEntity> findStudentById(@PathVariable("id") Long id) {
          return studentService.findStudentById(id);
     }

	@PostMapping("/add")
     public StudentEntity saveStudent(@RequestBody StudentEntity student) {
          return studentService.saveStudent(student);
     }

	@PutMapping("/update/{id}")
     public StudentEntity updateStudent(@PathVariable("id") Long id, @RequestBody StudentEntity student) {
          return studentService.updateStudent(id, student);
     }

	@DeleteMapping("/delete/{id}")
     public void deleteStudent(@PathVariable("id") Long id) {
          studentService.deleteStudent(id);
     }
}
