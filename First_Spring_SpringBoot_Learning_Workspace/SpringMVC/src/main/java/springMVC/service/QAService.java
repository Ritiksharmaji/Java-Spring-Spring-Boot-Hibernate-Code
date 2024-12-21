package springMVC.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import springMVC.model.QA;

public class QAService {

    public List<QA> readQAPairsFromFile(String filePath) {
        List<QA> qaList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    QA qa = new QA();
                    qa.setQuestion(parts[0]);
                    qa.setAnswer(parts[1]);
                    qaList.add(qa);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle error
        }
        return qaList;
    }

}
