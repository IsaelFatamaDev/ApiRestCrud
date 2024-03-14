package com.ApiRestCrud.ApiRestCrud.Services;

import com.ApiRestCrud.ApiRestCrud.Entity.TeacherEntity;

import java.util.List;
import java.util.Optional;

public interface TeacherServices {
	List<TeacherEntity> findAllTeachers();
	Optional<TeacherEntity> findTeacherById(Long id);
	TeacherEntity saveTeacher(TeacherEntity teacher);
	TeacherEntity updateTeacher(Long id, TeacherEntity teacher);
	void deleteTeacher(Long id);

}
