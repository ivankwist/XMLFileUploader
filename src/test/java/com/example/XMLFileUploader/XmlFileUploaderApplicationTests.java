package com.example.XMLFileUploader;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
=======
>>>>>>> d9d924f9688f511a5efee00b8802503a15946076

@SpringBootTest
class XmlFileUploaderApplicationTests {

	@Test
<<<<<<< HEAD
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
=======
	void contextLoads() {
>>>>>>> d9d924f9688f511a5efee00b8802503a15946076
	}

}
