package com.notes.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.notes.beans.CrudUE;
import com.notes.beans.UE;


@WebServlet("/AjouterUE")
public class AjouterUE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AjouterUE() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CrudUE crud = new CrudUE();
		request.setAttribute("ue", crud.recupererUEs());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterUE.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UE ue = new UE();
		ue.setCode_UE(request.getParameter("code_ue"));
		ue.setTitre(request.getParameter("titre"));
		ue.setCredit(request.getParameter("credit"));
		
		CrudUE crud = new CrudUE();
		crud.ajouterUE(ue);
		request.setAttribute("ue", crud.recupererUEs());

//		response.sendRedirect("/WEB-INF/ue.jsp");
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterUE.jsp").forward(request, response);
	}

}
