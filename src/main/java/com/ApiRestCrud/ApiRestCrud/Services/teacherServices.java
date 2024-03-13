package com.ApiRestCrud.ApiRestCrud.Services;

import com.ApiRestCrud.ApiRestCrud.entity.teacherEntity;

import java.util.List;
import java.util.Optional;

public interface teacherServices {
	List<teacherEntity> findAllTeachers();
	Optional<teacherEntity> findTeacherById(Long id);
	teacherEntity saveTeacher(teacherEntity teacher);
	teacherEntity updateTeacher(Long id, teacherEntity teacher);
	void deleteTeacher(Long id);

}
