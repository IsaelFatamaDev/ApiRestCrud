package com.ApiRestCrud.ApiRestCrud.controller;

import com.ApiRestCrud.ApiRestCrud.entity.StudentEntity;
import com.ApiRestCrud.ApiRestCrud.services.QrServices;
import com.ApiRestCrud.ApiRestCrud.services.StudentServices;
import com.ApiRestCrud.ApiRestCrud.utils.QRCodeGenerator;
import com.google.zxing.WriterException;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	private final StudentServices studentService;
	private final QrServices qrServices;
	public StudentController(StudentServices studentService, QrServices qrServices) {
		this.studentService = studentService;
		this.qrServices = qrServices;
	}

	@GetMapping
	public Map<String, Object> findAllStudents() {
		Map<String, Object> response = new HashMap<>();
		response.put("students", studentService.findAllStudents());
		response.put("qrs", qrServices.findAllQr());
		return response;
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
		try {
			String qrCodeBase64 = QRCodeGenerator.generateQRCodeBase64(student);
			System.out.println("QR Code Base64: " + qrCodeBase64);
		} catch (IOException | WriterException e) {
			e.printStackTrace();
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
