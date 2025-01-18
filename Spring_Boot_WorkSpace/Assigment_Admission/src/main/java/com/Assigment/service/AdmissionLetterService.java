package com.Assigment.service;

import com.Assigment.entity.Admission;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class AdmissionLetterService {

    public void generateAdmissionLetter(Admission admission, String outputFilePath) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(outputFilePath));
            document.open();

            document.add(new Paragraph("Admission Letter"));
            document.add(new Paragraph("Name: " + admission.getName()));
            document.add(new Paragraph("Date of Birth: " + admission.getDob()));
            document.add(new Paragraph("Course: " + admission.getCourse()));

            if (admission.getPhotoPath() != null) {
                Image photo = Image.getInstance(admission.getPhotoPath());
                document.add(photo);
            }

            if (admission.getSignaturePath() != null) {
                Image signature = Image.getInstance(admission.getSignaturePath());
                document.add(signature);
            }

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
