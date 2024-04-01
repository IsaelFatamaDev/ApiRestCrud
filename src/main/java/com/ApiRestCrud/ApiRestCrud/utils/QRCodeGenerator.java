package com.ApiRestCrud.ApiRestCrud.utils;

import com.ApiRestCrud.ApiRestCrud.entity.StudentEntity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {

	public static String generateQRCodeBase64(StudentEntity student) throws WriterException, IOException {
		var qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(
				"ID: " + student.getId() + "\n" +
						"Firstname: " + student.getFullName() + "\n" +
						"Dni: " + student.getDni(), BarcodeFormat.QR_CODE, 400, 400);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream, new MatrixToImageConfig());
		byte[] qrCodeBytes = outputStream.toByteArray();

		return Base64.encodeBase64String(qrCodeBytes);
	}
}
