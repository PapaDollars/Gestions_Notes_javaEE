package com.notes.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.notes.beans.CrudNotes;
import com.notes.beans.CrudUE;
import com.notes.beans.Etudiant;
import com.notes.beans.EtudiantController;
import com.notes.beans.Notes;

/**
 * Servlet implementation class AjouterNotes
 */
@WebServlet("/AjouterNotes")
public class AjouterNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterNotes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Etudiant p=null;
		String age =""; int num = 0;
		try {
		    age= request.getParameter("id_etudiant");
		     num = Integer.parseInt(age);
		} catch (NumberFormatException e) {
		    System.out.println("La valeur fournie n'est pas convertible en Integer");
		}
		

		Etudiant etudiant = new Etudiant();
		etudiant.setId_etudiant(num);
		
		EtudiantController etudiantcontroller = new EtudiantController();
		try {
			 p = etudiantcontroller.selectionerUneEtudiant(num);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		request.setAttribute("p", p);
		
		CrudUE  ue = new CrudUE();
		EtudiantController crud = new EtudiantController();
		try {
			request.setAttribute("etudiant", crud.selectionnerAllEtudiants());
			request.setAttribute("ue", ue.SelectionnerAllUe());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterNotes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cc1 ="",tp1="",sn1="",id_ue1="",id_etudiant1=""; int cc= 0, sn=0,tp=0,id_ue=0,id_etudiant=0;
		try {
		    cc1= request.getParameter("cc");
		    tp1= request.getParameter("tp");
		    sn1= request.getParameter("sn");
		    id_ue1= request.getParameter("id_ue");
		    id_etudiant1= request.getParameter("id_user");
		    sn1= request.getParameter("sn");
		    
		    id_ue = Integer.parseInt(id_ue1);
		    id_etudiant = Integer.parseInt(id_etudiant1);
		    cc = Integer.parseInt(cc1);
		    tp = Integer.parseInt(tp1);
		    sn = Integer.parseInt(sn1);
		} catch (NumberFormatException e) {
	
		}
		CrudUE  ue = new CrudUE();
		EtudiantController crud = new EtudiantController();
		Notes n = new Notes(id_etudiant,id_ue,cc,tp,sn);
		
		CrudNotes crudnote = new CrudNotes();
		try {
			request.setAttribute("etudiant", crud.selectionnerAllEtudiants());
			request.setAttribute("ue", ue.SelectionnerAllUe());
			crudnote.insererNote(n);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterNotes.jsp").forward(request, response);
	}

}
