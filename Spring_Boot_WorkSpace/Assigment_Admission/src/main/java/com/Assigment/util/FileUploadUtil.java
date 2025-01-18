package com.Assigment.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUploadUtil {

    // Method to handle file upload
    public static String saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
        // Create the directory if it doesn't exist
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();  // Creates the directory if it doesn't exist
        }

        // Define the file path where the file will be saved
        String filePath = uploadDir + File.separator + fileName;
        
        // Save the file to the specified path
        File fileToSave = new File(filePath);
        multipartFile.transferTo(fileToSave);

        return filePath;  // Return the path of the uploaded file
    }

    // Method to validate file type and size (e.g., image format, max size)
    public static boolean isValidFile(MultipartFile file) {
        // Check if file is empty
        if (file.isEmpty()) {
            return false;
        }

        // Validate file size (max 5MB)
        if (file.getSize() > 5 * 1024 * 1024) {  // 5MB size limit
            return false;
        }

        // Validate file type (allowing only images and PDFs)
        String fileType = file.getContentType();
        return fileType.equals("image/jpeg") || fileType.equals("image/png") || fileType.equals("application/pdf");
    }
}
