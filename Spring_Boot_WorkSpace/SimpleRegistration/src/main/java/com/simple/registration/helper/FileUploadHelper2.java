package com.simple.registration.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper2 {

//public final String UPLOAD_DIR = new ClassPathResource("static").getFile().getAbsolutePath();
//	
//	public FileUploadHelper2() throws  IOException{
//		
//	}
//	
//	public boolean uploadFile(MultipartFile multipart) {
//		
//		boolean f= false;
//		
//		try {
//			Files.copy(multipart.getInputStream(), Paths
//					.get(UPLOAD_DIR+File.separator+multipart
//					.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING );
//			f = true;
//			
//		}catch(Exception e) {
//			
//			e.printStackTrace();
//		}
//		
//		return f;
//	}
}
