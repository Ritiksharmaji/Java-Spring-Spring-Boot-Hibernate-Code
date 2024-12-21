package com.springboot.Thymeleaf.Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class QAService {

    // public List<QA> readQAPairsFromFile(String filePath) {
    // List<QA> qaList = new ArrayList<>();
    // try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
    // String line;
    // while ((line = br.readLine()) != null) {
    // String[] parts = line.split("ans->");
    // if (parts.length == 2) {
    // QA qa = new QA();
    // qa.setQuestion(parts[0]);
    // qa.setAnswer(parts[1]);
    // qaList.add(qa);
    // }
    // }
    // } catch (IOException e) {
    // e.printStackTrace(); // Handle error
    // }
    // return qaList;
    // }

    public List<QA> readQAPairsFromFile(String filePath) {
        List<QA> qaList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String question = null;
            StringBuilder answerBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Question->")) {
                    // If the line starts with "Question->", it's a new question
                    // If we have accumulated an answer, add it to the list
                    if (question != null && answerBuilder.length() > 0) {
                        QA qa = new QA();
                        qa.setQuestion(question);
                        qa.setAnswer(answerBuilder.toString().trim());
                        qaList.add(qa);
                        // Reset answer builder for the next question
                        answerBuilder = new StringBuilder();
                    }
                    // Extract the question from the line
                    question = line.substring("Question->".length()).trim();
                } else if (line.startsWith("ans->")) {
                    // If the line starts with "ans->", append it to the answer builder
                    answerBuilder.append(line.substring("ans->".length())).append("\n");
                }
            }
            // Add the last question-answer pair to the list
            if (question != null && answerBuilder.length() > 0) {
                QA qa = new QA();
                qa.setQuestion(question);
                qa.setAnswer(answerBuilder.toString().trim());
                qaList.add(qa);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle error
        }
        return qaList;
    }
}
