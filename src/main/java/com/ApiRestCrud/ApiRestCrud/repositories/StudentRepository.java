package com.ApiRestCrud.ApiRestCrud.repositories;

import com.ApiRestCrud.ApiRestCrud.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
	Optional<StudentEntity> findByDni(String dni);

	void deleteByDni(String dni);
}
