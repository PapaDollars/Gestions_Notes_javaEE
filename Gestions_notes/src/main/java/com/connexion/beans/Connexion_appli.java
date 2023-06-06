package com.connexion.beans;

import javax.servlet.http.HttpServletRequest;

public class Connexion_appli {
	
private String resultat;
private int identifiant;
	
	public void verifier(HttpServletRequest request) {	
		String adresse = request.getParameter("adresse");
		String password = request.getParameter("password");
		
		if(password.equals("1234") & adresse.equals("dollar@gmail.com")) {
			resultat = "Connexion reussi - Identifiants correct !!!";
			identifiant = 1;
		}
		else {
			resultat = "Identifiant incorrect.";
			identifiant = 0;
		}
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	
	
}
