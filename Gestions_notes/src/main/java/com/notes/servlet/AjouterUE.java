package com.notes.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.notes.beans.CrudUE;

import com.notes.beans.Ue;


@WebServlet("/AjouterUE")
public class AjouterUE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AjouterUE() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CrudUE crud = new CrudUE();
		try {
			request.setAttribute("ue", crud.SelectionnerAllUe());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterUE.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String code_ue = request.getParameter("code_ue");
		String libelle = request.getParameter("titre");
		
		String age =""; int credit = 0;
		try {
		    age= request.getParameter("credit");
		     credit = Integer.parseInt(age);
		} catch (NumberFormatException e) {
		    System.out.println("La valeur fournie n'est pas convertible en Integer");
		}
		
		Ue ue = new Ue(libelle,code_ue,credit);
		CrudUE crud = new CrudUE();
		try {
			crud.ajouterUE(ue);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			request.setAttribute("ue", crud.SelectionnerAllUe());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		response.sendRedirect("/WEB-INF/ue.jsp");
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterUE.jsp").forward(request, response);
	}

}
