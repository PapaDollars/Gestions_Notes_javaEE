package com.notes.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import javax.servlet.http.HttpServletRequest;

//import com.connexion.beans.Connexion_db;

public class CrudUE {
	private Connection connexion;
	
	public List<UE> recupererUEs() {
        List<UE> uEs = new ArrayList<UE>();
        Statement statement = null;
        ResultSet resultat = null;
//        Connection connexion = null;
        
//        Connexion_db connexion = Connexion_db() ;
        
        try {
        	loadDatabase();
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT id_ue,code_UE,titre,credit FROM ue;");

            // Récupération des données
            while (resultat.next()) {
            	String id_ue= resultat.getString("id_ue");
            	String code_UE= resultat.getString("code_UE");
            	String titre= resultat.getString("titre");
            	String credit= resultat.getString("credit");
                
                UE ue = new UE();
                ue.setId_ue(id_ue);
                ue.setCode_UE(code_UE);
                ue.setTitre(titre);
                ue.setCredit(credit);
                
                uEs.add(ue);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }
        
        return uEs;
    }
    
    
    public void ajouterUE(UE ue) {
        loadDatabase();
        
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO ue(code_UE,titre,credit) VALUES( ?, ?, ? );");
            preparedStatement.setString(1, ue.getCode_UE());
            preparedStatement.setString(2, ue.getTitre());
            preparedStatement.setString(3, ue.getCredit());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void loadDatabase() {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/notes", "dollar", "dollar0000");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
//    public void modifierUE(UE ue,HttpServletRequest request) {
//        loadDatabase();
//        
//        try {
//            PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE ue SET code_UE=? WHERE code_UE=?;");
//            preparedStatement.setString(1, ue.getCode_UE());
//            preparedStatement.setString(2, ue.getCode_UE());
//            
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public void supprimerUE(UE ue,HttpServletRequest request) {
//        loadDatabase();
//        
//        try {
//            PreparedStatement preparedStatement = connexion.prepareStatement("DELETE FROM code_UE WHERE code_UE=?;");
//            preparedStatement.setString(1, ue.getCode_UE());
//            
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    
}
