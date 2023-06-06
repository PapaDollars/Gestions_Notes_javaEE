package com.connexion.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion_db {
	Connection connexion;

	public Connection loadDatabase() {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/notes", "dollar", "dollar0000");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connexion;
    }
    
}

