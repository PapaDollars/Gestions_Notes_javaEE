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
 * Servlet implementation class ModifierUE
 */
@WebServlet("/ModifierUE")
public class ModifierUE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	int id_ue=0;
    public ModifierUE() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Ue p = null;
		
		
		String id =""; int num = 0;
		try {
		    id= request.getParameter("id_ue");
		     num = Integer.parseInt(id);
		     id_ue = num;
		} catch (NumberFormatException e) {
		    System.out.println("La valeur fournie n'est pas convertible en Integer");
		}
		
		
		
		
		CrudUE etudiantcontroller = new CrudUE();
		try {
			 p = etudiantcontroller.selectionnerUE(num);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	
		
		request.setAttribute("p", p);
		
		
		
		
		
		
		
		CrudUE crud = new CrudUE();
		try {
			request.setAttribute("ue", crud.SelectionnerAllUe());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierUE.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Ue etudiant = new Ue();
		etudiant.setCode_ue(request.getParameter("code_ue"));
		
		etudiant.setLibelle(request.getParameter("libelle"));
		etudiant.setId_ue(id_ue);
		
		
		String age =""; int num = 0;
		try {
		    age= request.getParameter("credit");
		     num = Integer.parseInt(age);
		} catch (NumberFormatException e) {
		    System.out.println("La valeur fournie n'est pas convertible en Integer");
		}
		
		etudiant.setCredit(num);
		CrudUE crud = new CrudUE();
		try {
			crud.modifierUE(etudiant);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			request.setAttribute("ue", crud.SelectionnerAllUe());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierUE.jsp").forward(request, response);
	}

}
