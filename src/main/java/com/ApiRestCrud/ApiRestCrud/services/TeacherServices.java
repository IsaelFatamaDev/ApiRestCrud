package com.ApiRestCrud.ApiRestCrud.services;

import com.ApiRestCrud.ApiRestCrud.entity.TeacherEntity;

import java.util.List;
import java.util.Optional;

public interface TeacherServices {
	List<TeacherEntity> findAllTeachers();
	Optional<TeacherEntity> findTeacherById(Long id);
	TeacherEntity saveTeacher(TeacherEntity teacher);
	TeacherEntity updateTeacher(Long id, TeacherEntity teacher);
	void deleteTeacher(Long id);

}
