package com.ApiRestCrud.ApiRestCrud.Controller;

import com.ApiRestCrud.ApiRestCrud.Services.TeacherServices;
import com.ApiRestCrud.ApiRestCrud.Entity.TeacherEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
	private final TeacherServices teacherService;

	public TeacherController(TeacherServices teacherService) {
		this.teacherService = teacherService;
	}

	@GetMapping("/all")
	public List<TeacherEntity> findAllTeachers() {
		return teacherService.findAllTeachers();
	}

	@GetMapping("/{id}")
	public Optional<TeacherEntity> findTeacherById(@PathVariable("id") Long id) {
		return teacherService.findTeacherById(id);
	}

	@PostMapping("/add")
	public TeacherEntity saveTeacher(@RequestBody TeacherEntity teacher) {
		return teacherService.saveTeacher(teacher);
	}

	@PutMapping("/update/{id}")
	public TeacherEntity updateTeacher(@PathVariable("id") Long id, @RequestBody TeacherEntity teacher) {
		return teacherService.updateTeacher(id, teacher);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteTeacher(@PathVariable("id") Long id) {
		teacherService.deleteTeacher(id);
	}
}
