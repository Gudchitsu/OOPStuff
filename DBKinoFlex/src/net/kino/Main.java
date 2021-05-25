package net.kino;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String dbURL = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "MILLER";
        String password = "KOLOBOK";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to load class.");
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(dbURL,username,password);
            System.out.println ("Connection to Oracle DataBase successful !");
        } catch (SQLException ex) {
            System.out.println ("Wrong door buddy:");
            ex.printStackTrace();
        }
    }
}
