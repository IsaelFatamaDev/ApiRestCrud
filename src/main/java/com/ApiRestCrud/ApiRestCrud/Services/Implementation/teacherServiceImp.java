package com.ApiRestCrud.ApiRestCrud.Services.Implementation;

import com.ApiRestCrud.ApiRestCrud.Repositories.teacherRepository;
import com.ApiRestCrud.ApiRestCrud.Services.teacherServices;
import com.ApiRestCrud.ApiRestCrud.entity.teacherEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class teacherServiceImp implements teacherServices {

	private final teacherRepository teacherRepository;

	public teacherServiceImp(com.ApiRestCrud.ApiRestCrud.Repositories.teacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}

	@Override
	public List<teacherEntity> findAllTeachers() {
		return teacherRepository.findAll();
	}

	@Override
	public Optional<teacherEntity> findTeacherById(Long id) {
		return teacherRepository.findById(id);
	}

	@Override
	public teacherEntity saveTeacher(teacherEntity teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public teacherEntity updateTeacher(Long id, teacherEntity teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public void deleteTeacher(Long id) {
		teacherRepository.deleteById(id);
	}
}
