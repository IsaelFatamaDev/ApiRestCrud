package com.ApiRestCrud.ApiRestCrud.controller;

import com.ApiRestCrud.ApiRestCrud.entity.QrEntity;
import com.ApiRestCrud.ApiRestCrud.services.QrServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/qr")
public class QrController {

	private final QrServices qrServices;

	@Autowired
	public QrController(QrServices qrServices) {
		this.qrServices = qrServices;
	}

	@GetMapping("/qr/")
	public List<QrEntity> getAllQr() {
		return qrServices.findAllQr();
	}

}