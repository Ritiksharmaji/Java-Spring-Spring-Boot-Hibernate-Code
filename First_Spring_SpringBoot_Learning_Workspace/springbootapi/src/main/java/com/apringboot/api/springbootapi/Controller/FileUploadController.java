package com.apringboot.api.springbootapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.apringboot.api.springbootapi.helper.FileUploadHelper;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize());
        // System.out.println(file.getContentType());
        // -------------------------------------
        // if (file.isEmpty()) {
        // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request
        // must contant the File ");
        // }

        try {

            String FileType = file.getContentType();
            String FileName = file.getOriginalFilename();
            Long FileSize = file.getSize();

            if (FileSize == 0) {
                System.out.println(FileSize);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contant the File ");

            }
            if (!file.getContentType().equals("image/jpeg")) {
                System.out.println(FileType);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("the file type  must be in image/jpge formate ");
            }
            // ------NOW file upload code ---------------------------
            // E:\CODE\spring and springBoot project\springbootapi\src\main\resources\static

            boolean upload = fileUploadHelper.uploadFile(file);

            if (upload) {
                System.out.println("file uploaded");
                // return ResponseEntity.ok("file uploaded is successfully");

                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());

                /*
                 * String org.springframework.web.multipart.MultipartFile.getOriginalFilename()
                 * Return the original filename in the client's filesystem.
                 */

                // ServletUriComponentsBuilder.fromCurrentContextPath() - to get localhost://8081

            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        // return ResponseEntity.ok("working");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file not uploaded properly");

    }

}
