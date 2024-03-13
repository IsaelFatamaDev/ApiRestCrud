package com.ApiRestCrud.ApiRestCrud.Repositories;

import com.ApiRestCrud.ApiRestCrud.entity.teacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface teacherRepository extends JpaRepository<teacherEntity, Long> {
}
