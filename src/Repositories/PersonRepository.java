package Repositories;

import Models.PersonModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRepository {
    /*
    public static PersonModel login(String pass, String userName) {

        ResultSet resultSet = null;
        String selectSql = "SELECT * FROM person WHERE password=? AND username=?";// +pass+"AND username="+userName;
        try ( Connection connection = DriverManager.getConnection(DatabaseQuery.CONNECTIONURL);  PreparedStatement prepsSelectProduct = connection.prepareStatement(selectSql);) {
            prepsSelectProduct.setString(1, pass);
            prepsSelectProduct.setString(2, userName);
            resultSet = prepsSelectProduct.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int salary = resultSet.getInt("salary");
                String fname = resultSet.getString("fname");
                int age = resultSet.getInt("age");
                String lname = resultSet.getString("lname");
                String password = resultSet.getString("password");
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                int mangerid = resultSet.getInt("manager_ID");
                String name = fname + " " + lname;

                return new PersonModel(id, name, age, username, password, role, salary, mangerid);
            }

            //  statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }
    */
    public static PersonModel login(String pass, String userName) {

        String selectSql = "SELECT * FROM person WHERE password='"+pass+"' AND username='"+userName+"'";
        try{
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                double salary = resultSet.getDouble("salary");
                String fname = resultSet.getString("fname");
                int age = resultSet.getInt("age");
                String lname = resultSet.getString("lname");
                String password = resultSet.getString("password");
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                int mangerid = resultSet.getInt("manager_ID");
                String name = fname + " " + lname;

                return new PersonModel(id, name, age, username, password, role, salary, mangerid);
            }

            //  statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }
    
}
