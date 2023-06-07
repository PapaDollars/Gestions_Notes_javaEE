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
 * Servlet implementation class SupprimerEtudiants
 */
@WebServlet("/SupprimerEtudiants")
public class SupprimerEtudiants extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerEtudiants() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String age =""; int num = 0;
		try {
		    age= request.getParameter("id_etudiant");
		     num = Integer.parseInt(age);
		} catch (NumberFormatException e) {
		    System.out.println("La valeur fournie n'est pas convertible en Integer");
		}
		

		
		
		Etudiant produit = new Etudiant();
		produit.setId_etudiant(num);
		
		EtudiantController crud_ = new EtudiantController();
		try {
			crud_.DeleteEtudiant(num);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EtudiantController crud = new EtudiantController();
		try {
			request.setAttribute("etudiant", crud.selectionnerAllEtudiants());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		this.getServletContext().getRequestDispatcher("/WEB-INF/supprimerEtudiants.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		EtudiantController crud = new EtudiantController();
		try {
			request.setAttribute("produits", crud.selectionnerAllEtudiants());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		this.getServletContext().getRequestDispatcher("/WEB-INF/supprimerEtudiants.jsp").forward(request, response);
	}

}
