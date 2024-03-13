package com.ApiRestCrud.ApiRestCrud.Controller;

import com.ApiRestCrud.ApiRestCrud.Services.teacherServices;
import com.ApiRestCrud.ApiRestCrud.entity.teacherEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers/apiv1")
public class teacherController {
	private final teacherServices teacherService;

	public teacherController(teacherServices teacherService) {
		this.teacherService = teacherService;
	}

	@GetMapping("/all")
	public List<teacherEntity> findAllTeachers() {
		return teacherService.findAllTeachers();
	}

	@GetMapping("/{id}")
	public Optional<teacherEntity> findTeacherById(@PathVariable("id") Long id) {
		return teacherService.findTeacherById(id);
	}

	@PostMapping("/add")
	public teacherEntity saveTeacher(@RequestBody teacherEntity teacher) {
		return teacherService.saveTeacher(teacher);
	}

	@PutMapping("/update/{id}")
	public teacherEntity updateTeacher(@PathVariable("id") Long id, @RequestBody teacherEntity teacher) {
		return teacherService.updateTeacher(id, teacher);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteTeacher(@PathVariable("id") Long id) {
		teacherService.deleteTeacher(id);
	}
}
