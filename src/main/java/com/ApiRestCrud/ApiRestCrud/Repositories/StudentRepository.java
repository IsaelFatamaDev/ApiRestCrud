package com.ApiRestCrud.ApiRestCrud.Repositories;

import com.ApiRestCrud.ApiRestCrud.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
