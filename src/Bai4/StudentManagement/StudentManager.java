package Bai4.StudentManagement;

import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class StudentManager {
    public void addStudent() throws Exception {
        try {
            int studentID;
            java.sql.Date studentDateOfBirth;
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-5GA3GV2H;instance=SQLEXPRESS;database=Student;encrypt=true;trustServerCertificate=true;", "cuong", "11111");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into StudentData(ID, Name, DateOfBirth, Gender, Phone, GPA) values (?,?,?,?,?,?)");
            Scanner inputFromUser = new Scanner(System.in);
            System.out.print("Enter student ID: ");
            try {
                studentID = inputFromUser.nextInt();
            } catch (Exception e) {
                throw new Exception("Error, please enter student id again");
            }
            inputFromUser.nextLine();
            System.out.print("Enter student name: ");
            String studentName = inputFromUser.nextLine();
            System.out.print("Enter student day of birth: ");
            try {
                studentDateOfBirth = java.sql.Date.valueOf(inputFromUser.nextLine());
            } catch (Exception e) {
                throw new Exception("Error, please enter date of birth again");
            }
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

            int successQuery = preparedStatement.executeUpdate();
            if (successQuery > 0) {
                System.out.println("Student added successfully");
            }
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayStudent() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-5GA3GV2H;instance=SQLEXPRESS;database=Student;encrypt=true;trustServerCertificate=true;", "cuong", "Hanyeu99");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from StudentData");

            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("Data not found");
            } else {
                int length = 109;
                String line = String.format("%0" + length + "d", 0).replace('0', '-');
                System.out.println("+" + line + "+");
                System.out.printf("| %-8s | %-16s | %-20s | %-14s | %-14s | %-20s |%n", "ID", "NAME", "DATE OF BIRTH", "GENDER", "PHONE", "GPA");
                System.out.println("+" + line + "+");


                while (resultSet.next()) {
                    String column1 = resultSet.getString(1);
                    String column2 = resultSet.getString(2);
                    String column3 = resultSet.getString(3);
                    String column4 = resultSet.getString(4);
                    String column5 = resultSet.getString(5);
                    String column6 = resultSet.getString(6);
                    System.out.printf("| %-8s | %-16s | %-20s | %-14s | %-14s | %-20s |%n", column1, column2, column3, column4, column5, column6);
                }

                System.out.println("+" + line + "+");
                connection.close();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStudent() {

    }

    public void findStudent() throws Exception {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-5GA3GV2H;instance=SQLEXPRESS;database=Student;encrypt=true;trustServerCertificate=true;", "cuong", "Hanyeu99");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT TOP 1 * FROM StudentData WHERE StudentData.id = ?");

            try {
                System.out.print("Enter student id: ");
                int studentID = new Scanner(System.in).nextInt();
                preparedStatement.setInt(1, studentID);
            } catch (Exception e) {
                throw new Exception("Error, please enter student ID again");
            }
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("Data not found");
                return;
            }

            int length = 109;
            String line = String.format("%0" + length + "d", 0).replace('0', '-');
            System.out.println("+" + line + "+");
            System.out.printf("| %-8s | %-16s | %-20s | %-14s | %-14s | %-20s |%n", "ID", "NAME", "DATE OF BIRTH", "GENDER", "PHONE", "GPA");
            System.out.println("+" + line + "+");

            while (resultSet.next()) {
                String column1 = resultSet.getString(1);
                String column2 = resultSet.getString(2);
                String column3 = resultSet.getString(3);
                String column4 = resultSet.getString(4);
                String column5 = resultSet.getString(5);
                String column6 = resultSet.getString(6);
                System.out.printf("| %-8s | %-16s | %-20s | %-14s | %-14s | %-20s |%n", column1, column2, column3, column4, column5, column6);
            }

            System.out.println("+" + line + "+");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeStudent() throws Exception {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-5GA3GV2H;instance=SQLEXPRESS;database=Student;encrypt=true;trustServerCertificate=true;", "cuong", "Hanyeu99");
            PreparedStatement preparedStatement = connection.prepareStatement("delete from StudentData WHERE StudentData.id = ?");
            try {
                System.out.print("Enter student id: ");
                int studentID = new Scanner(System.in).nextInt();
                preparedStatement.setInt(1, studentID);
            } catch (Exception e) {
                throw new Exception("Error, please enter student ID again");
            }

            int successQuery = preparedStatement.executeUpdate();
            if (successQuery > 0) {
                System.out.println("Removed successfully");
                return;
            }
            System.out.println("Data not found");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void sortStudent() {
        System.out.println("[6] Sort by");

        Scanner inputFromUser = new Scanner(System.in);
        boolean inputSuccess = false;
        int choice;

        while (!inputSuccess) {
            try {
                System.out.println("1. ID");
                System.out.println("2. Name");
                System.out.println("3. Date Of Birth");
                System.out.println("4. GPA");
                System.out.println("5. Return");
                System.out.print("Please select [1 - 5]: ");
                try {
                    choice = inputFromUser.nextInt();
                    switch (choice) {
                        case 1-> {
                            this.sortBy();
                            inputSuccess = true;
                        }
                        case 5 -> inputSuccess = true;
                        default -> {
                            System.out.println("Number does not exist, please try again");
                            inputSuccess = true;
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Error, please enter a number sir");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                inputFromUser.nextLine();
            }
        }
    }

    private void sortBy() throws Exception {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-5GA3GV2H;instance=SQLEXPRESS;database=Student;encrypt=true;trustServerCertificate=true;", "cuong", "Hanyeu99");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from StudentData order by ID desc");
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("Data not found");
                return;
            }

            int length = 109;
            String line = String.format("%0" + length + "d", 0).replace('0', '-');
            System.out.println("+" + line + "+");
            System.out.printf("| %-8s | %-16s | %-20s | %-14s | %-14s | %-20s |%n", "ID", "NAME", "DATE OF BIRTH", "GENDER", "PHONE", "GPA");
            System.out.println("+" + line + "+");

            while (resultSet.next()) {
                String column1 = resultSet.getString(1);
                String column2 = resultSet.getString(2);
                String column3 = resultSet.getString(3);
                String column4 = resultSet.getString(4);
                String column5 = resultSet.getString(5);
                String column6 = resultSet.getString(6);
                System.out.printf("| %-8s | %-16s | %-20s | %-14s | %-14s | %-20s |%n", column1, column2, column3, column4, column5, column6);
            }
            System.out.println("+" + line + "+");

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
