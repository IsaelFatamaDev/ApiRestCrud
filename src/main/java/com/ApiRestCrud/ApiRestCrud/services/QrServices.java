package com.ApiRestCrud.ApiRestCrud.services;

import com.ApiRestCrud.ApiRestCrud.entity.QrEntity;
import com.ApiRestCrud.ApiRestCrud.entity.StudentEntity;

import java.util.List;
import java.util.Optional;

public interface QrServices {
	List<QrEntity> findAllQr();
	Optional<QrEntity> findByName(String name);
	QrEntity saveQr(QrEntity qrEntity);
	QrEntity updateQr(QrEntity qrEntity);
}
