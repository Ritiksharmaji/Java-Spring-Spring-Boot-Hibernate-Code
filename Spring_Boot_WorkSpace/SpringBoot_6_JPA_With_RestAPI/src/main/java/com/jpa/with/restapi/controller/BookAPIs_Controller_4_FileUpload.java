package com.jpa.with.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.jpa.with.restapi.entities.Book3;
import com.jpa.with.restapi.helper1.FileUploadHelper;
import com.jpa.with.restapi.service.BookService_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v4") // Optional base path for better organization
public class BookAPIs_Controller_4_FileUpload {
   
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("image1") MultipartFile file){
// --------------- to display the details of the file ----------------------------------------		
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		
// -----------------------------------------------------------------------------
		if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("plz upload the file");
		}
		
		if( ! file.getContentType().equals("image/jpeg")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("plz upload the file in jpeg format !!!");
		}
		
		// where we have to store the file..
		boolean uploadFile = fileUploadHelper.uploadFile(file);
		
		if(uploadFile) {
			return ResponseEntity.ok("file upload done");
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.body("error during file upload !!!");
		}
		
//		return ResponseEntity.ok("working");
	}
}
