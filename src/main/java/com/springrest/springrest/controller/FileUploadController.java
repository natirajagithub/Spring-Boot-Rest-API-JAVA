package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springrest.springrest.helper.FileUploadHelper;

@RestController
public class FileUploadController {

@Autowired
private FileUploadHelper fileuploadhelper;

	
	@PostMapping("/upload-file")
	public ResponseEntity<String>uploadFile(@RequestParam("file")MultipartFile file)
	{
//		System.out.print(file.getOriginalFilename());
//		System.out.print(file.getSize());
//		System.out.print(file.getContentType());
//		System.out.print(file.getName());
//	
		try {
			
		
	
		if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
		}
		
		if(!file.getContentType().equals("image/png")) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("omly PNG file Allowed");
	}
		
		boolean f = fileuploadhelper.uploadFile(file);
		
		if(f) 
		
		{

			return ResponseEntity.ok("Uploded file successfully");
//			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
		
		
//	return ResponseEntity.ok("worrking");
	}

}
