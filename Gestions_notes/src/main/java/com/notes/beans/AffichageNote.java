package com.notes.beans;

public class AffichageNote {
	
	private String nom;
	private String prenom;
	private String code_ue ;
	private String adresse;
	private String matricule;
	private int cc;
	private int age;
	private int tp;
	private int sn;
	
	
	
	public AffichageNote(String nom, String prenom, String code_ue, String adresse, String matricule, int cc, int age,
			int tp, int sn) {
	
		this.nom = nom;
		this.prenom = prenom;
		this.code_ue = code_ue;
		this.adresse = adresse;
		this.matricule = matricule;
		this.cc = cc;
		this.age = age;
		this.tp = tp;
		this.sn = sn;
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
	public String getCode_ue() {
		return code_ue;
	}
	public void setCode_ue(String code_ue) {
		this.code_ue = code_ue;
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
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getTp() {
		return tp;
	}
	public void setTp(int tp) {
		this.tp = tp;
	}
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	
}
