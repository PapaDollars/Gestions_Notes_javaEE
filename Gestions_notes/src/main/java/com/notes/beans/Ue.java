package com.notes.beans;


	
	public class Ue {

	    private  int id_ue;

	    private String libelle;

	    private String code_ue;

	    private  int credit;
	    
	    
	    
	    public Ue() {}

	    public Ue(String libelle, String code_ue, int credit) {
			
			this.libelle = libelle;
			this.code_ue = code_ue;
			this.credit = credit;
		}

	    public Ue(int id_ue, String libelle, String code_ue, int credit) {
			this.id_ue = id_ue;
			this.libelle = libelle;
			this.code_ue = code_ue;
			this.credit = credit;
		}

		public int getId_ue() {
	        return id_ue;
	    }

	    public void setId_ue(int id_ue) {
	        this.id_ue = id_ue;
	    }

	    public String getLibelle() {
	        return libelle;
	    }

	    public void setLibelle(String libelle) {
	        this.libelle = libelle;
	    }

	    public String getCode_ue() {
	        return code_ue;
	    }

	    public void setCode_ue(String code_ue) {
	        this.code_ue = code_ue;
	    }

	    public int getCredit() {
	        return credit;
	    }

	    public void setCredit(int credit) {
	        this.credit = credit;
	    }
	}
	
	

