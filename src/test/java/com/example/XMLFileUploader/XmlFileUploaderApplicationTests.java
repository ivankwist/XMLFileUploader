package com.example.XMLFileUploader;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class XmlFileUploaderApplicationTests {

	@Test
	public void testXMLUploadStatus() {
		FileUploadController fileUploadController = new FileUploadController();
		HttpStatus status = fileUploadController.getHttpStatus("xml", "application/xml");
		assertEquals(status, HttpStatus.OK);
	}

	@Test
	public void testNotXMLUploadStatus() {
		FileUploadController fileUploadController = new FileUploadController();
		HttpStatus status = fileUploadController.getHttpStatus("txt", "text/plain");
		assertEquals(status, HttpStatus.NOT_ACCEPTABLE);
	}

}
