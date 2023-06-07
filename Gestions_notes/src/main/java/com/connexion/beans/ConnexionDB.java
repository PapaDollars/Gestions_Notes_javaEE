package com.connexion.beans;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDB {

    private static String url  = "jdbc:mysql://localhost:3306/GestionNotes";

    private static String username = "franck";
    private static String password = "Njie09.";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Connection connection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        connection = DriverManager.getConnection(url,username, password);
        System.out.println("Connexion avec succes");
        return connection;


    }


}