package Bai5.StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class StudentManager {
//    List<Student> studentLists = new LinkedList<>();

    public void addStudent() throws Exception {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-5GA3GV2H\\SQLEXPRESS;instance=SQLEXPRESS;database=Student;encrypt=true;trustServerCertificate=true;", "cuong", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into StudentData(ID, Name, DateOfBirth, Gender, Phone, GPA) values (?,?,?,?,?,?)");
            Scanner inputFromUser = new Scanner(System.in);
            System.out.print("Enter student ID: ");
            int studentID = inputFromUser.nextInt();
            inputFromUser.nextLine();
            System.out.print("Enter student name: ");
            String studentName = inputFromUser.nextLine();
            System.out.print("Enter student day of birth: ");
            java.sql.Date studentDateOfBirth = java.sql.Date.valueOf(inputFromUser.nextLine());
            System.out.print("Enter student gender: ");
            String studentGender = inputFromUser.nextLine();
            System.out.print("Enter student phone: ");
            String studentPhone = inputFromUser.nextLine();
            System.out.print("Enter student GPA: ");
            float studentGPA = inputFromUser.nextFloat();
            Student student = new Student(studentID, studentPhone, studentGPA, studentName, studentGender, studentDateOfBirth);
            preparedStatement.setInt(1, student.getStudentID());
            preparedStatement.setString(2, student.getStudentName());
            preparedStatement.setDate(3, student.getStudentDateOfBirth());
            preparedStatement.setString(4, student.getStudentGender());
            preparedStatement.setString(5, student.getStudentPhone());
            preparedStatement.setFloat(6, student.getStudentGPA());

            int updated = preparedStatement.executeUpdate();
            if (updated > 0) {
                System.out.println("Insert Student success!!!");
            }

            preparedStatement.close();
            connection.close();
            System.out.println("Student added successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayStudent() {
    }

    public void updateStudent() {
    }

    public void findStudent() {
    }

    public void removeStudent() {
    }

    public void sortStudent() {
    }
}
