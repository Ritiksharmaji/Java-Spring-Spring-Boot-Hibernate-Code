package com.spring.orm_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.orm_1.dao.StudentDao;
import com.spring.orm_1.entities.Student;

public class App {
    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the Student Management App!");

        // Load the Spring ApplicationContext and get the StudentDao bean
        ApplicationContext context = new ClassPathXmlApplicationContext("springHbConfig.xml");
        
// ----------------- to insert simple one record -----------------------------------------------------------------
//      Student st = new Student(235,"Adil khan","Guntur");
//      StudentDao bean = context.getBean("studentDao",StudentDao.class);
//      int insert = bean.insert(st);
//      System.out.println(insert);  
      
//------------------ to perform CURD operation ---------------------------------------------------------------------------
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        // Initialize a BufferedReader for user input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean go = true; // Control variable for the loop

        while (go) {
            // Display the menu
            System.out.println("\n========== MENU ==========");
            System.out.println("Press 1: Add a new Student");
            System.out.println("Press 2: Display all Students");
            System.out.println("Press 3: Get details of a Student");
            System.out.println("Press 4: Delete a Student");
            System.out.println("Press 5: Update a Student");
            System.out.println("Press 6: Exit");
            System.out.println("==========================");
            System.out.print("Enter your choice: ");

            try {
                // Read the user's choice
                int input = Integer.parseInt(br.readLine());

                switch (input) {
                    case 1:
                        // Add a new student
                        System.out.print("Enter Student ID: ");
                        int id = Integer.parseInt(br.readLine()); // Read student ID
                        System.out.print("Enter Student Name: ");
                        String name = br.readLine(); // Read student name
                        System.out.print("Enter Student City: ");
                        String city = br.readLine(); // Read student city

                        // Create a new Student object and insert it into the database
                        Student student = new Student(id, name, city);
                        int result = studentDao.insert(student);
                        System.out.println("Student added successfully with ID: " + result);
                        break;

                    case 2:
                        // Display all students
                        System.out.println("Displaying all students...");
                        List<Student> allStudents = studentDao.getAllStudent();
                        // Iterate over and print each student record
                        for (Student s : allStudents) {
                            System.out.println("ID: " + s.getStudentId() + ", Name: " + s.getStudentName() + ", City: " + s.getStudentCity());
                        }
                        break;

                    case 3:
                        // Get details of a student
                        System.out.print("Enter Student ID to fetch details: ");
                        int studentId = Integer.parseInt(br.readLine());
                        Student fetchedStudent = studentDao.fetStudent(studentId);
                        // Check if the student exists
                        if (fetchedStudent != null) {
                            System.out.println("ID: " + fetchedStudent.getStudentId() + ", Name: " + fetchedStudent.getStudentName() + ", City: " + fetchedStudent.getStudentCity());
                        } else {
                            System.out.println("Student with ID " + studentId + " does not exist.");
                        }
                        break;

                    case 4:
                        // Delete a student
                        System.out.print("Enter Student ID to delete: ");
                        int deleteId = Integer.parseInt(br.readLine());
                        studentDao.deleteStudent(deleteId); // Call the delete method
                        System.out.println("Student with ID " + deleteId + " deleted successfully.");
                        break;

                    case 5:
                        // Update a student
                        System.out.print("Enter Student ID to update: ");
                        int updateId = Integer.parseInt(br.readLine()); // Read student ID
                        System.out.print("Enter new Student Name: ");
                        String updateName = br.readLine(); // Read updated name
                        System.out.print("Enter new Student City: ");
                        String updateCity = br.readLine(); // Read updated city

                        // Create a Student object with updated details
                        Student updatedStudent = new Student(updateId, updateName, updateCity);
                        studentDao.UpdateStudent(updatedStudent); // Update the record
                        System.out.println("Student with ID " + updateId + " updated successfully.");
                        break;

                    case 6:
                        // Exit the application
                        go = false; // Exit the loop
                        System.out.println("Exiting the application. Thank you!");
                        break;

                    default:
                        // Handle invalid input
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                // Handle exceptions (e.g., invalid input, database errors)
                System.out.println("An error occurred. Please try again.");
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
