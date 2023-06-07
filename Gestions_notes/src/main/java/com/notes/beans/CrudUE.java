package com.notes.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connexion.beans.ConnexionDB;

//import javax.servlet.http.HttpServletRequest;

//import com.connexion.beans.Connexion_db;

public class CrudUE {

	
    // Selectionner Une UE
    public Ue selectionnerUE(int id) throws ClassNotFoundException, SQLException{
        Ue ue = null;
        Connection con =  ConnexionDB.getConnection();

        String sql = "select * from ue where id_ue=?";
        PreparedStatement requetePrepared = con.prepareStatement(sql);
        requetePrepared.setInt(1, id);

        ResultSet resultat = requetePrepared.executeQuery();

        while(resultat.next()) {
        	int id_ue= resultat.getInt("id_ue");
        	String code_UE= resultat.getString("code_UE");
        	String titre= resultat.getString("libelle");
        	int credit= resultat.getInt("credit");
            
          
            
            ue = new Ue(id_ue,titre,code_UE,credit);
        }

        return ue;
    }

	
	
	
	
	
	
	
	
	
	
	
	public List<Ue> SelectionnerAllUe() throws ClassNotFoundException {
        List<Ue> uEs = new ArrayList<Ue>();
        Statement statement = null;
      
//        Connection connexion = null;
        
//        Connexion_db connexion = Connexion_db() ;
        
        try {
        	 Connection con =  ConnexionDB.getConnection();
           
        	 
            // Exécution de la requête
        	 String sql = "select * from ue";
             PreparedStatement requetePrepared = con.prepareStatement(sql);


             ResultSet resultat = requetePrepared.executeQuery();

            // Récupération des données
            while (resultat.next()) {
            	int id_ue= resultat.getInt("id_ue");
            	String code_UE= resultat.getString("code_UE");
            	String titre= resultat.getString("libelle");
            	int credit= resultat.getInt("credit");
                
                
                uEs.add(new Ue(id_ue,titre,code_UE,credit));
            }
        } catch (SQLException e) {
        } finally {
         //
        }
        
        return uEs;
    }
    
    
    public void ajouterUE(Ue ue) throws ClassNotFoundException {
      
        
        try {
        	 Connection con =  ConnexionDB.getConnection();
            
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO ue(libelle,code_ue,credit) VALUES( ?, ?, ? );");
            preparedStatement.setString(1, ue.getLibelle());
            preparedStatement.setString(2, ue.getCode_ue());
            preparedStatement.setInt(3, ue.getCredit());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void modifierUE(Ue ue) throws ClassNotFoundException, SQLException {
    	Connection con =  ConnexionDB.getConnection();
        
        PreparedStatement preparedStatement = con.prepareStatement("update ue set libelle=?, code_ue = ?,credit=? where id_ue=?");

        preparedStatement.setString(1, ue.getLibelle());
        preparedStatement.setString(2, ue.getCode_ue());
        preparedStatement.setInt(3, ue.getCredit());
        preparedStatement.setInt(4, ue.getId_ue());
        
        preparedStatement.executeUpdate();

        
    }
    
    
    public void deleteUe(int id) throws SQLException, ClassNotFoundException {
    	Connection con =  ConnexionDB.getConnection();

       
        String sql = "delete  from ue where id_ue=?";
        PreparedStatement requetePrepared = con.prepareStatement(sql);
        requetePrepared.setInt(1, id);
        requetePrepared.executeUpdate();

       
    }

    

    
}
