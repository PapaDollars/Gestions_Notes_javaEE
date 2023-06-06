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


public class CrudEtudiants {
	private Connection connexion;
	
	public List<Etudiants> recupererEtudiants() {
        List<Etudiants> etudiants = new ArrayList<Etudiants>();
        Statement statement = null;
        ResultSet resultat = null;
//        Connection connexion = null;
        
//        Connexion_db connexion = Connexion_db() ;
        
        try {
        	loadDatabase();
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT id_etudiant,matricule,nom,prenom,sexe FROM etudiants;");

            // Récupération des données
            while (resultat.next()) {
            	String id_etudiant= resultat.getString("id_etudiant");
                String matricule = resultat.getString("matricule");
                String nom= resultat.getString("nom");
                String prenom= resultat.getString("prenom");
                String sexe= resultat.getString("sexe");
                
                Etudiants etudiant = new Etudiants();
                etudiant.setId_etudiant(id_etudiant);
                etudiant.setMatricule(matricule);
                etudiant.setNom(nom);
                etudiant.setPrenom(prenom);
                etudiant.setSexe(sexe);
                
    			etudiants.add(etudiant);
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
        
        return etudiants;
    }
    
    
    public void ajouterEtudiant(Etudiants etudiant) {
        loadDatabase();
        
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO etudiants(matricule,nom,prenom,filiere,sexe) VALUES(?, ?, ?, ?);");
            preparedStatement.setString(1, etudiant.getMatricule());
            preparedStatement.setString(2, etudiant.getNom());
            preparedStatement.setString(3, etudiant.getPrenom());
            preparedStatement.setString(4, etudiant.getSexe());
            
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
    
//    public void modifierEtudiant(Etudiants etudiant,HttpServletRequest request) {
//        loadDatabase();
//        
//        try {
//            PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE etudiants SET matricule=?, nom=?, prenom=?, filiere=?, sexe=? WHERE matricule=?;");
//            preparedStatement.setString(1, etudiant.getMatricule());
//            preparedStatement.setString(2, etudiant.getNom());
//            preparedStatement.setString(3, etudiant.getPrenom());
//            preparedStatement.setString(4, etudiant.getFiliere());
//            preparedStatement.setString(5, etudiant.getSexe());
//            preparedStatement.setString(6, etudiant.getMatricule());
//            
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public void supprimerEtudiant(Etudiants etudiant,HttpServletRequest request) {
//        loadDatabase();
//        
//        try {
//            PreparedStatement preparedStatement = connexion.prepareStatement("DELETE FROM id_etudiant WHERE id_etudiant=?;");
//            preparedStatement.setString(1, etudiant.getId_etudiant());
//            
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    

}
