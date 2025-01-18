package com.jpa.with.restapi.helper1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component // Mark this class as a Spring-managed bean
public class FileUploadHelper {
	
	public final String 
	UPLOAD_DIR ="D:\\java\\Code\\Java-Spring-Spring-Boot-Hibernate-Code\\Spring_Boot_WorkSpace\\SpringBoot_6_JPA_With_RestAPI\\src\\main\\resources\\static\\image";

	public boolean uploadFile(MultipartFile multipart) {
		
		boolean f= false;
		
		try {
			
// ---------------- first way to upload the file --------------------------------
//			InputStream inputStream = multipart.getInputStream();
//			
//			byte data[] = new byte[inputStream.available()];
//			inputStream.read();
//			
//			//write on the file location
//			
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+"\\"+ multipart.getOriginalFilename());
//			fos.write(data);
//			fos.flush();
//			fos.close();
			
			
// ------------------------- second way -----------------------------------
			//  here it take three arguments 
			// first= input stream
			// second = file path with name
			// option means either replace or create.
			Files.copy(multipart.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipart.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING );
		
			
			f = true;
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return f;
	}
}
