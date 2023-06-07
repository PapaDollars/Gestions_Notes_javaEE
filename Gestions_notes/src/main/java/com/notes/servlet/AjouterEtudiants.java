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


@WebServlet("/AjouterEtudiants")
public class AjouterEtudiants extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjouterEtudiants() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EtudiantController crud = new EtudiantController();
		try {
			request.setAttribute("etudiant", crud.selectionnerAllEtudiants());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterEtudiants.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Etudiant etudiant = new Etudiant();
		etudiant.setMatricule(request.getParameter("matricule"));
		etudiant.setNom(request.getParameter("nom"));
		etudiant.setPrenom(request.getParameter("prenom"));
		etudiant.setSexe(request.getParameter("sexe"));
		etudiant.setAdresse(request.getParameter("adresse"));
		
		
		
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
			crud.AjoutEtudiant(etudiant);
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

		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterEtudiants.jsp").forward(request, response);

	}

}
