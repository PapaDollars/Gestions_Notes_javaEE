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
import com.notes.beans.Notes;


@WebServlet("/ModifierNotes")
public class ModifierNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ModifierNotes() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int num = 0;
		try {
			String id_note =  request.getParameter("id_note");
		     num = Integer.parseInt(id_note);
		} catch (NumberFormatException e) {
		    System.out.println("La valeur fournie n'est pas convertible en Integer");
		}
		CrudNotes crud = new CrudNotes();
		CrudUE crudUe =  new CrudUE();
		try {
			request.setAttribute("note", crud.selectionerUneNotes(num));
			request.setAttribute("etudiant", crud.SelectionerAllNotes());
			request.setAttribute("ue", crudUe.SelectionnerAllUe());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierNotes.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cc1 ="",tp1="",sn1="",id_ue1="",id_etudiant1="",id_note1=""; int cc= 0, sn=0,tp=0,id_ue=0,id_etudiant=0, id_note=0;
		try {
		    cc1= request.getParameter("cc");
		    tp1= request.getParameter("tp");
		    sn1= request.getParameter("sn");
		    id_ue1= request.getParameter("id_ue");
		    id_etudiant1= request.getParameter("id_etudiant");
		    id_note1= request.getParameter("id_note");
		    
		    id_ue = Integer.parseInt(id_ue1);
		    id_etudiant = Integer.parseInt(id_etudiant1);
		    cc = Integer.parseInt(cc1);
		    tp = Integer.parseInt(tp1);
		    sn = Integer.parseInt(sn1);
		    id_note = Integer.parseInt(id_note1);
		} catch (NumberFormatException e) {
	
		}
		
		
	Notes n = new Notes(id_note,id_etudiant,id_ue,cc,tp,sn);
		PrintWriter pw = response.getWriter();
		
		
		CrudNotes crud = new CrudNotes();
		CrudUE crudUe =  new CrudUE();
		CrudNotes crudnote = new CrudNotes();
		try {
			crudnote.modifierNotes(n);
			
			request.setAttribute("etudiant", crud.SelectionerAllNotes());
			request.setAttribute("ue", crudUe.SelectionnerAllUe());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierNotes.jsp").forward(request, response);
	}

}
