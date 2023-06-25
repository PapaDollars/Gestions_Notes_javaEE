package com.notes.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connexion.beans.ConnexionDB;

public class CrudNotes {
	
	
	  // Inserer un Notes

    // Inserer un Notes
    public void insererNote(Notes notes) throws ClassNotFoundException, SQLException {
        Connection con =  ConnexionDB.getConnection();
        String sql = "insert into notes(id_etudiant,id_ue,cc,tp,sn) values(?,?,?,?,?)";
        PreparedStatement requetePrepared = con.prepareStatement(sql);
        requetePrepared.setInt(1, notes.getId_etudiant());
        requetePrepared.setInt(2, notes.getId_ue());
        requetePrepared.setInt(3, notes.getCc());
        requetePrepared.setInt(4, notes.getTp());
        requetePrepared.setInt(5, notes.getSn());
        requetePrepared.executeUpdate();

    }
    
    
    public void deleteNotes(int id) throws ClassNotFoundException, SQLException {
        Connection con =  ConnexionDB.getConnection();

        boolean value;
        String sql = "delete from notes where id_note=?";
        PreparedStatement requetePrepared = con.prepareStatement(sql);
        requetePrepared.setInt(1, id);

        requetePrepared.executeUpdate();
      
    }
    
    public void modifierNotes(Notes notes) throws ClassNotFoundException, SQLException {
        Connection con =  ConnexionDB.getConnection();

    
        String sql = "update notes set cc= ? , tp=?, sn=?  where id_note= ?";
        PreparedStatement requetePrepared = con.prepareStatement(sql);
        requetePrepared.setInt(1, notes.getCc());
        requetePrepared.setInt(2, notes.getTp());
        requetePrepared.setInt(3, notes.getSn());
        requetePrepared.setInt(4, notes.getId_note());
        
        requetePrepared.executeUpdate();

      
    }

  public List<AffichageNote> SelectionerAllNotes() throws ClassNotFoundException, SQLException
  {
      List<AffichageNote> notes =  new ArrayList<AffichageNote>();
      Connection con =  ConnexionDB.getConnection();

      String sql = "select id_note,matricule,nom,prenom,age,adresse,cc,sn,tp,code_ue from notes join  etudiant using(id_etudiant) join ue using(id_ue)";
      PreparedStatement requetePrepared = con.prepareStatement(sql);


      ResultSet resultat = requetePrepared.executeQuery();

      while(resultat.next())
      {
    	  int id_note = resultat.getInt("id_note");
          String nom =  resultat.getString("nom");
          String  prenom=  resultat.getString("prenom");
          String  adresse=  resultat.getString("adresse");
          String  code_ue=  resultat.getString("code_ue");
          String matricule = resultat.getString("matricule");
          int age =  resultat.getInt("age");
          int cc =  resultat.getInt("cc");
          int sn =  resultat.getInt("sn");
          int tp =  resultat.getInt("tp");
          
          notes.add(new AffichageNote(id_note,nom,prenom,code_ue,adresse,matricule,cc,age,sn,tp));
          
      }

      return  notes;
  }
  public List<AffichageNote> selectionnerWithUE(int id) throws ClassNotFoundException, SQLException
  {
      List<AffichageNote> notes =  new ArrayList<AffichageNote>();
      Connection con =  ConnexionDB.getConnection();

      String sql = "select id_etudiant,matricule,nom,prenom,age,adresse,cc,sn,tp,code_ue from notes join  etudiant using(id_etudiant) join ue using(id_ue) where id_ue=?";
      PreparedStatement requetePrepared = con.prepareStatement(sql);
      requetePrepared.setInt(1, id);

      ResultSet resultat = requetePrepared.executeQuery();

      while(resultat.next())
      {
    	  
    	  int id_etudiant = resultat.getInt("id_etudiant");
          String nom =  resultat.getString("nom");
          String  prenom=  resultat.getString("prenom");
          String  adresse=  resultat.getString("adresse");
          String  code_ue=  resultat.getString("code_ue");
          String matricule = resultat.getString("matricule");
          int age =  resultat.getInt("age");
          int cc =  resultat.getInt("cc");
          int sn =  resultat.getInt("sn");
          int tp =  resultat.getInt("tp");
          
          notes.add(new AffichageNote(id_etudiant,nom,prenom,code_ue,adresse,matricule,cc,age,sn,tp));
          
      }

      return  notes;
  }
  
  // Selectionner Un Product
  public AffichageNote selectionerUneNotes(int id) throws ClassNotFoundException, SQLException{
	  AffichageNote etudiant = null;
      Connection con =  ConnexionDB.getConnection();

      String sql = "select id_ue,id_etudiant,id_note,matricule,nom,prenom,age,adresse,cc,sn,tp,code_ue from notes join  etudiant using(id_etudiant) join ue using(id_ue) where id_note=?";
      PreparedStatement requetePrepared = con.prepareStatement(sql);
      requetePrepared.setInt(1, id);

      ResultSet resultat = requetePrepared.executeQuery();

      while(resultat.next()) {
    	  int id_ue = resultat.getInt("id_note");
    	  int id_etudiant = resultat.getInt("id_etudiant");
    	  int id_note = resultat.getInt("id_note");
          String nom =  resultat.getString("nom");
          String  prenom=  resultat.getString("prenom");
          String  adresse=  resultat.getString("adresse");
          String  code_ue=  resultat.getString("code_ue");
          String matricule = resultat.getString("matricule");
          int age =  resultat.getInt("age");
          int cc =  resultat.getInt("cc");
          int sn =  resultat.getInt("sn");
          int tp =  resultat.getInt("tp");
          
          etudiant  = new AffichageNote(id_ue,id_etudiant,id_note,nom,prenom,code_ue,adresse,matricule,cc,age,sn,tp);
      }

      return etudiant;
  }
  
}
