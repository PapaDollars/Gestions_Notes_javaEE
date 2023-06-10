package com.notes.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.notes.beans.*;
import com.connexion.beans.ConnexionDB;



public class EtudiantController {
    public void AjoutEtudiant(Etudiant etudiant) throws ClassNotFoundException, SQLException {
        Connection con =  ConnexionDB.getConnection();
        String sql = "insert into etudiant(nom,prenom,sexe,age,telephone,adresse,matricule) values(?,?,?,?,?,?,?)";
        PreparedStatement requetePrepared = con.prepareStatement(sql);
        requetePrepared.setString(1, etudiant.getNom());
        requetePrepared.setString(2, etudiant.getPrenom());
        requetePrepared.setString(3, etudiant.getSexe());
        requetePrepared.setInt(4, etudiant.getAge());
        requetePrepared.setString(5, etudiant.getTelephone());
        requetePrepared.setString(6, etudiant.getAdresse());
        requetePrepared.setString(7, etudiant.getMatricule());

        requetePrepared.executeUpdate();

    }


    // Selectionner Un Product
    public Etudiant selectionerUneEtudiant(int id) throws ClassNotFoundException, SQLException{
        Etudiant etudiant = null;
        Connection con =  ConnexionDB.getConnection();

        String sql = "select * from etudiant where id_etudiant=?";
        PreparedStatement requetePrepared = con.prepareStatement(sql);
        requetePrepared.setInt(1, id);

        ResultSet resultat = requetePrepared.executeQuery();

        while(resultat.next()) {
        	int id_etudiant =  resultat.getInt("id_etudiant");
            String nom =  resultat.getString("nom");
            String prenom =  resultat.getString("prenom");
            String sexe =  resultat.getString("sexe");
            int age =  resultat.getInt("age");
            String telephone =  resultat.getString("telephone");
            String adresse =  resultat.getString("adresse");

            String matricule =  resultat.getString("matricule");
            etudiant  =   new Etudiant(id_etudiant,nom,prenom,sexe,age,telephone,adresse,matricule);
        }

        return etudiant;
    }

    // Selectionner Tout les Products

    public List<Etudiant> selectionnerAllEtudiants() throws ClassNotFoundException, SQLException
    {
        List<Etudiant> etudiants =  new ArrayList<Etudiant>();
        Connection con =  ConnexionDB.getConnection();

        String sql = "select * from etudiant";
        PreparedStatement requetePrepared = con.prepareStatement(sql);


        ResultSet resultat = requetePrepared.executeQuery();

        while(resultat.next())
        {
        	int id_etudiant =  resultat.getInt("id_etudiant");
            String nom =  resultat.getString("nom");
            String prenom =  resultat.getString("prenom");
            String sexe =  resultat.getString("sexe");
            int age =  resultat.getInt("age");
            String telephone =  resultat.getString("telephone");
            String adresse =  resultat.getString("adresse");

            String matricule =  resultat.getString("matricule");
            etudiants.add(new Etudiant(id_etudiant,nom,prenom,sexe,age,telephone,adresse,matricule));
        }

        return  etudiants;
    }

    // Supprimer un Etudiant

    public void DeleteEtudiant(int id) throws ClassNotFoundException, SQLException {
        Connection con =  ConnexionDB.getConnection();

       
        String sql = "delete  from etudiant where id_etudiant=?";
        PreparedStatement requetePrepared = con.prepareStatement(sql);
        requetePrepared.setInt(1, id);

        requetePrepared.executeUpdate();

       
    }

    // Modifier Un Etudiant

    public void modifierEtudiant(Etudiant etudiant) throws ClassNotFoundException, SQLException {
        Connection con =  ConnexionDB.getConnection();

       
        String sql = "update etudiant set nom= ? , prenom=?, sexe=?, age=?  , telephone=? , adresse=?, matricule=? where id_etudiant= ?";
        PreparedStatement requetePrepared = con.prepareStatement(sql);
        requetePrepared.setString(1, etudiant.getNom());
        requetePrepared.setString(2, etudiant.getPrenom());
        requetePrepared.setString(3, etudiant.getSexe());
        requetePrepared.setInt(4, etudiant.getAge());
        requetePrepared.setString(5, etudiant.getTelephone());
        requetePrepared.setString(6, etudiant.getAdresse());
        requetePrepared.setString(7, etudiant.getMatricule());
        requetePrepared.setInt(8, etudiant.getId_etudiant());
        requetePrepared.executeUpdate();
        
    }
}