package Bai4.ConnectToDatabase;


import java.sql.*;

public class Main {
    public static void main(String[] args) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-MTJHGEM\\SQLEXPRESS;database=bai_tap_tren_lop;encrypt=true;trustServerCertificate=true;" ,"cuong","hanyeu");
                System.out.println("Connect successfully");
                PreparedStatement  preparedStatement = connection.prepareStatement( "select * from dbo.student_name");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String column1 = resultSet.getString(1);
                    String column2 = resultSet.getString(2);
                    System.out.println(column1 + "\t" + column2 + "\t");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

}
