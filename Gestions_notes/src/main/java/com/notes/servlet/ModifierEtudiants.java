package com.notes.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.notes.beans.Etudiant;
import com.notes.beans.EtudiantController;

/**
 * Servlet implementation class ModifierEtudiants
 */
@WebServlet("/ModifierEtudiants")
public class ModifierEtudiants extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int id_etudiant=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierEtudiants() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Etudiant p = null;
		
	
		String id =""; int num = 0;
		try {
		    id= request.getParameter("id_etudiant");
		     num = Integer.parseInt(id);
		     id_etudiant = num;
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
		
		
		
		EtudiantController crud = new EtudiantController();
		try {
			request.setAttribute("etudiant", crud.selectionnerAllEtudiants());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierEtudiants.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Etudiant etudiant = new Etudiant();
		etudiant.setMatricule(request.getParameter("matricule"));
		etudiant.setNom(request.getParameter("nom"));
		etudiant.setPrenom(request.getParameter("prenom"));
		etudiant.setSexe(request.getParameter("sexe"));
		etudiant.setAdresse(request.getParameter("adresse"));
		etudiant.setId_etudiant(id_etudiant);
		
		
		String age =""; int num = 0;
		try {
		    age= request.getParameter("age");
		     num = Integer.parseInt(age);
		} catch (NumberFormatException e) {
		    System.out.println("La valeur fournie n'est pas convertible en Integer");
		}
		
		
		
		etudiant.setAge(num);
		etudiant.setTelephone(request.getParameter("telephone"));
		
		EtudiantController crud = new EtudiantController();
		try {
			crud.modifierEtudiant(etudiant);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			request.setAttribute("etudiant", crud.selectionnerAllEtudiants());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierEtudiants.jsp").forward(request, response);
	}

}
