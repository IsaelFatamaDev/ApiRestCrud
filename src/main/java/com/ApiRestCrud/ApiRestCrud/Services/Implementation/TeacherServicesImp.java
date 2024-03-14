package com.ApiRestCrud.ApiRestCrud.Services.Implementation;

import com.ApiRestCrud.ApiRestCrud.Repositories.TeacherRepository;
import com.ApiRestCrud.ApiRestCrud.Services.TeacherServices;
import com.ApiRestCrud.ApiRestCrud.Entity.TeacherEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServicesImp implements TeacherServices {

	private final TeacherRepository teacherRepository;

	public TeacherServicesImp(TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}

	@Override
	public List<TeacherEntity> findAllTeachers() {
		return teacherRepository.findAll();
	}

	@Override
	public Optional<TeacherEntity> findTeacherById(Long id) {
		return teacherRepository.findById(id);
	}

	@Override
	public TeacherEntity saveTeacher(TeacherEntity teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public TeacherEntity updateTeacher(Long id, TeacherEntity teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public void deleteTeacher(Long id) {
		teacherRepository.deleteById(id);
	}
}
