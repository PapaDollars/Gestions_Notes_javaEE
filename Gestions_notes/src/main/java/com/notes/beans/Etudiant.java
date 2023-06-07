package com.notes.beans;

	


public class Etudiant {

    private int id_etudiant;
    private  String nom;
    private  String prenom;
    private String sexe;

    private  int age;

    private String telephone;
    private String adresse;
    private String matricule;

    
    public Etudiant(){}
    public Etudiant(String nom, String prenom, String sexe, int age, String telephone, String adresse, String matricule) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.age = age;
        this.telephone = telephone;
        this.adresse =adresse;
        this.matricule = matricule;
    }
    
    public Etudiant(int id_etudiant,String nom, String prenom, String sexe, int age, String telephone, String adresse, String matricule) {
    	this.id_etudiant = id_etudiant;
    	this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.age = age;
        this.telephone = telephone;
        this.adresse =adresse;
        this.matricule = matricule;
        
    }



	public int getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(int id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
}