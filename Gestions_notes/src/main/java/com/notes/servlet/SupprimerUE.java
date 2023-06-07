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
import com.notes.beans.Ue;

/**
 * Servlet implementation class SupprimerUE
 */
@WebServlet("/SupprimerUE")
public class SupprimerUE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerUE() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String age =""; int num = 0;
		try {
		    age= request.getParameter("id_ue");
		     num = Integer.parseInt(age);
		} catch (NumberFormatException e) {
		    System.out.println("La valeur fournie n'est pas convertible en Integer");
		}
		
		
		CrudUE c = new  CrudUE();
		try {
			c.deleteUe(num);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		CrudUE crud = new CrudUE();
		try {
			request.setAttribute("ue", crud.SelectionnerAllUe());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/supprimerUE.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CrudUE crud = new CrudUE();
		try {
			request.setAttribute("ue", crud.SelectionnerAllUe());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		

		this.getServletContext().getRequestDispatcher("/WEB-INF/supprimerUE.jsp").forward(request, response);
	}

}
