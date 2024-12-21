package com.blogapp.apis.services;

import java.io.*;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	String uploadImage(String path, MultipartFile file)throws IOException;
	InputStream getResource(String path,String filename) throws FileNotFoundException;

}
