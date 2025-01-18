package com.Assigment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    private static final String UPLOAD_DIRECTORY = "uploads";

    @GetMapping("/upload")
    public String showUploadPage() {
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadFile(MultipartFile file) {
        try {
            String uploadPath = System.getProperty("user.dir") + File.separator + UPLOAD_DIRECTORY;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            file.transferTo(new File(uploadPath + File.separator + file.getOriginalFilename()));
            return "redirect:/upload-success";
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/upload-failure";
        }
    }
}