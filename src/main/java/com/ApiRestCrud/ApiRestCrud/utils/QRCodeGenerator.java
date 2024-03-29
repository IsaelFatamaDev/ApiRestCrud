package com.ApiRestCrud.ApiRestCrud.utils;

import com.ApiRestCrud.ApiRestCrud.entity.StudentEntity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {

	public static void generateQRCode(StudentEntity student) throws WriterException, IOException {
		String qrCodePath = "C:\\Users\\javie\\IdeaProjects\\ApiRestCrud\\src\\main\\resources\\QrImage\\";
		String qrCodeName = student.getDni() + " - QRCODE.png";
		String qrCodeFullPath = qrCodePath + qrCodeName;
		var qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(
			   "ID: " + student.getId() + "\n" +
					 "Firstname: " + student.getFullName() + "\n" +
					 "Dni: " + student.getDni(), BarcodeFormat.QR_CODE, 400, 400);
		Path path = FileSystems.getDefault().getPath(qrCodeFullPath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	}
}
