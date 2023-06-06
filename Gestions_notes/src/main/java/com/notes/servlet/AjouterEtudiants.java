package com.notes.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.notes.beans.CrudEtudiants;
import com.notes.beans.Etudiants;


@WebServlet("/AjouterEtudiants")
public class AjouterEtudiants extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjouterEtudiants() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CrudEtudiants crud = new CrudEtudiants();
		request.setAttribute("etudiant", crud.recupererEtudiants());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterEtudiants.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Etudiants etudiant = new Etudiants();
		etudiant.setMatricule(request.getParameter("matricule"));
		etudiant.setNom(request.getParameter("nom"));
		etudiant.setPrenom(request.getParameter("prenom"));
		etudiant.setSexe(request.getParameter("sexe"));
		
		CrudEtudiants crud = new CrudEtudiants();
		crud.ajouterEtudiant(etudiant);
		request.setAttribute("etudiant", crud.recupererEtudiants());

		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterEtudiants.jsp").forward(request, response);

	}

}
