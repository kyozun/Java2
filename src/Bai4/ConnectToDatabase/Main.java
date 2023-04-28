package Bai4.ConnectToDatabase;


import java.sql.*;

public class Main {
    public static void main(String[] args) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-5GA3GV2H;instance=SQLEXPRESS;database=Student;encrypt=true;trustServerCertificate=true;" ,"cuong","Hanyeu99");
                System.out.println("Connect successfully");
                PreparedStatement preparedStatement = connection.prepareStatement("select * from StudentData");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String column1 = resultSet.getString(1);
                    String column2 = resultSet.getString(2);
                    String column3 = resultSet.getString(3);
                    System.out.println(column1 + "\t" + column2 + "\t" + column3 + "\t");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

}
