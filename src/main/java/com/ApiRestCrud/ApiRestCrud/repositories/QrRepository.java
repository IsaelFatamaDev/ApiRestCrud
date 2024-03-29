package com.ApiRestCrud.ApiRestCrud.repositories;

import com.ApiRestCrud.ApiRestCrud.entity.QrEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QrRepository extends JpaRepository<QrEntity, String> {
}