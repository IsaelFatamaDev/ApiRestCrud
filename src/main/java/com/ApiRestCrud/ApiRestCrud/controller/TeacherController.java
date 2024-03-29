package com.ApiRestCrud.ApiRestCrud.controller;

import com.ApiRestCrud.ApiRestCrud.services.TeacherServices;
import com.ApiRestCrud.ApiRestCrud.entity.TeacherEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {
	private final TeacherServices teacherService;

	public TeacherController(TeacherServices teacherService) {
		this.teacherService = teacherService;
	}

	@GetMapping
	public List<TeacherEntity> findAllTeachers() {
		return teacherService.findAllTeachers();
	}

	@GetMapping("/{dni}")
	public Optional<TeacherEntity> findTeacherById(@PathVariable("id") Long id) {
		return teacherService.findTeacherById(id);
	}

	@PostMapping
	public TeacherEntity saveTeacher(@RequestBody TeacherEntity teacher) {
		return teacherService.saveTeacher(teacher);
	}

	@PutMapping("/{dni}")
	public TeacherEntity updateTeacher(@PathVariable("dni") Long id, @RequestBody TeacherEntity teacher) {
		return teacherService.updateTeacher(id, teacher);
	}

	@DeleteMapping("/{dni}")
	public void deleteTeacher(@PathVariable("dni") Long id) {
		teacherService.deleteTeacher(id);
	}
}
