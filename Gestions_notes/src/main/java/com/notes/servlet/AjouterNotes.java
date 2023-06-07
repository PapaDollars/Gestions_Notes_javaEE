package com.notes.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.notes.beans.CrudUE;
import com.notes.beans.Etudiant;
import com.notes.beans.EtudiantController;

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
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterNotes.jsp").forward(request, response);
	}

}
