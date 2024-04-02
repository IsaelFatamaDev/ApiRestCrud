package com.ApiRestCrud.ApiRestCrud.services.implementation;

import com.ApiRestCrud.ApiRestCrud.entity.QrEntity;
import com.ApiRestCrud.ApiRestCrud.repositories.QrRepository;
import com.ApiRestCrud.ApiRestCrud.services.QrServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QrServicesImp implements QrServices {
	private final QrRepository qrRepository;

	public QrServicesImp(QrRepository qrRepository) {
		this.qrRepository = qrRepository;
	}


	@Override
	public List<QrEntity> findAllQr() {
		return List.of();
	}

	@Override
	public Optional<QrEntity> findByName(String name) {
		return Optional.empty();
	}

	@Override
	public QrEntity saveQr(QrEntity qrEntity) {
		return qrRepository.save(qrEntity);
	}

	@Override
	public QrEntity updateQr(QrEntity qrEntity) {
		return null;
	}
}
