package Final;

import Bai4.StudentManagement.Student;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactManager {
    public void addContact() throws Exception {
        try {
            Scanner inputFromUser = new Scanner(System.in);
            System.out.print("Enter contact name: ");
            String contactName = inputFromUser.nextLine();
            System.out.print("Enter company: ");
            String company = inputFromUser.nextLine();
            System.out.print("Enter email: ");
            String email = inputFromUser.nextLine();
            System.out.print("Enter phone number: ");
            int phoneNumber = inputFromUser.nextInt();
            /*Tạo đối tượng mới*/
            Contact contact = new Contact(contactName, company, email, phoneNumber);

            /*Tạo kết nối*/
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-5GA3GV2H\\SQLEXPRESS;database=Contact;encrypt=true;trustServerCertificate=true;", "sa", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Contact(ContactName, Company, Email, PhoneNumber) values (?,?,?,?)");
            preparedStatement.setString(1, contact.getContactName());
            preparedStatement.setString(2, contact.getCompany());
            preparedStatement.setString(3, contact.getEmail());
            preparedStatement.setInt(4, contact.getPhoneNumber());

            int update =  preparedStatement.executeUpdate();
            if (update > 0) {
                System.out.println("Contact added successfully");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Please enter a number");
        }catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public void findContact() {
        try {
            System.out.print("Enter contact name: ");
            String contactName = new Scanner(System.in).nextLine();

            Connection connection = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-5GA3GV2H\\SQLEXPRESS;database=Contact;encrypt=true;trustServerCertificate=true;", "sa", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT TOP 1 * FROM Contact where ContactName = ?");
            preparedStatement.setString(1, contactName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("Data not found");
                return;
            }

            int length = 83;
            String line = String.format("%0" + length + "d", 0).replace('0', '-');
            System.out.println("+" + line + "+");
            System.out.printf("| %-16s | %-16s | %-20s | %-20s |%n", "CONTACT NAME", "COMPANY", "EMAIL", "PHONE NUMBER");
            System.out.println("+" + line + "+");

            while (resultSet.next()) {
                String column1 = resultSet.getString(1);
                String column2 = resultSet.getString(2);
                String column3 = resultSet.getString(3);
                String column4 = resultSet.getString(4);

                System.out.printf("| %-16s | %-16s | %-20s | %-20s |%n", column1, column2, column3, column4);
            }

            System.out.println("+" + line + "+");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayContact() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-5GA3GV2H\\SQLEXPRESS;database=Contact;encrypt=true;trustServerCertificate=true;", "sa", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT  * FROM Contact where ContactName = ?");
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("Data not found");
                return;
            }

            int length = 83;
            String line = String.format("%0" + length + "d", 0).replace('0', '-');
            System.out.println("+" + line + "+");
            System.out.printf("| %-16s | %-16s | %-20s | %-20s |%n", "CONTACT NAME", "COMPANY", "EMAIL", "PHONE NUMBER");
            System.out.println("+" + line + "+");

            while (resultSet.next()) {
                String column1 = resultSet.getString(1);
                String column2 = resultSet.getString(2);
                String column3 = resultSet.getString(3);
                String column4 = resultSet.getString(4);

                System.out.printf("| %-16s | %-16s | %-20s | %-20s |%n", column1, column2, column3, column4);
            }

            System.out.println("+" + line + "+");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
