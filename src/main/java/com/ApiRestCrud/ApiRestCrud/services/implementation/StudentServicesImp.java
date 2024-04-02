package com.ApiRestCrud.ApiRestCrud.services.implementation;

import com.ApiRestCrud.ApiRestCrud.entity.QrEntity;
import com.ApiRestCrud.ApiRestCrud.entity.StudentEntity;
import com.ApiRestCrud.ApiRestCrud.repositories.QrRepository;
import com.ApiRestCrud.ApiRestCrud.repositories.StudentRepository;
import com.ApiRestCrud.ApiRestCrud.services.StudentServices;
import com.ApiRestCrud.ApiRestCrud.utils.QRCodeGenerator;
import com.google.zxing.WriterException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServicesImp implements StudentServices {
	private final StudentRepository studentRepository;
	private final QrRepository qrRepository;

	public StudentServicesImp(StudentRepository studentRepository, QrRepository qrRepository) {
		this.studentRepository = studentRepository;
		this.qrRepository = qrRepository;
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
		StudentEntity savedStudent = studentRepository.save(student);
		try {
			String qrCodeBase64 = QRCodeGenerator.generateQRCodeBase64(student);
			QrEntity qrEntity = new QrEntity();
			qrEntity.setNameQr("QR_" + student.getFullName());
			qrEntity.setState(true);
			qrEntity.setImageData(qrCodeBase64.getBytes());
			qrEntity.setStudentEntity(savedStudent);
			qrRepository.save(qrEntity);
		} catch (IOException | WriterException e) {
			e.printStackTrace();

		}
		return savedStudent;
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
			throw new IllegalArgumentException("No se puede actualizar el estudiante. El estudiante con DNI " + student.getDni() + " no existe.");
		}
	}

	@Override
	public void deleteStudent(String dni) {
		studentRepository.deleteByDni(dni);
	}
}
