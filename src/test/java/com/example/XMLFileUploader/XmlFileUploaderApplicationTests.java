package com.example.XMLFileUploader;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class XmlFileUploaderApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testXMLFileUpload() throws Exception {
		MockMultipartFile testFile = new MockMultipartFile("file", "file.xml", "application/xml", "xml".getBytes());

		this.mockMvc.perform(multipart("/")
				.file(testFile))
				.andExpect(status().is(200))
				.andExpect(jsonPath("$.filename").value(testFile.getOriginalFilename()))
				.andExpect(jsonPath("$.size").value(testFile.getSize()));
	}

	@Test
	public void testNotXMLFileUpload() throws Exception {
		MockMultipartFile testFile = new MockMultipartFile("file", "file.txt", "text/plain", "txt".getBytes());

		this.mockMvc.perform(multipart("/")
				.file(testFile))
				.andExpect(status().is(406))
				.andExpect(jsonPath("$.filename").value(testFile.getOriginalFilename()))
				.andExpect(jsonPath("$.size").value(testFile.getSize()));
	}

}
