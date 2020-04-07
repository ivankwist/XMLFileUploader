package com.example.XMLFileUploader;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;

@RestController
public class FileUploadController {

    @PostMapping("/")
    public ResponseEntity<UploadResponse> handleFileUpload(@RequestParam("file") MultipartFile file) {
        UploadResponse response = new UploadResponse(file.getOriginalFilename(), new Date().toString(), file.getSize());

        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String mimeType = file.getContentType();

        return new ResponseEntity<UploadResponse>(response, getHttpStatus(extension, mimeType));
    }

    public HttpStatus getHttpStatus(String extension, String mimeType){
        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;;

        if(extension.equals("xml") && mimeType.equals("application/xml")){
            status = HttpStatus.OK;
        }

        return status;
    }

}
