package com.notes.beans;

public class Notes {

	private int id_note;
	private int id_etudiant;
	private int id_ue;
	private int cc;
	private int tp;
	private int sn;
	
	
	
	public Notes( int id_etudiant, int id_ue, int cc, int tp, int sn) {
	
		this.id_etudiant = id_etudiant;
		this.id_ue = id_ue;
		this.cc = cc;
		this.tp = tp;
		this.sn = sn;
	}
	public Notes( int id_note,int id_etudiant, int id_ue, int cc, int tp, int sn) {
		
		this.id_note = id_note;
		this.id_etudiant = id_etudiant;
		this.id_ue = id_ue;
		this.cc = cc;
		this.tp = tp;
		this.sn = sn;
	}
	public int getId_note() {
		return id_note;
	}
	public void setId_note(int id_note) {
		this.id_note = id_note;
	}
	public int getId_etudiant() {
		return id_etudiant;
	}
	public void setId_etudiant(int id_etudiant) {
		this.id_etudiant = id_etudiant;
	}
	public int getId_ue() {
		return id_ue;
	}
	public void setId_ue(int id_ue) {
		this.id_ue = id_ue;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
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
