package com.notes.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connexion.beans.Connexion_appli;


@WebServlet("/SeConnecter")
public class SeConnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SeConnecter() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/seconnecter.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String form = "Username ou mot de passe Incorrect";
		String address = request.getParameter("username");
		String password = request.getParameter("password");
		
		String sql = "select * from admin where username=? and password=?";
		
		Connection con = null;
		try {
			con = com.connexion.beans.ConnexionDB.getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, address);
			ps.setString(2, password);
			
			ResultSet rs =  ps.executeQuery();
			
			
				
		if(rs.next()){
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		}
		else {
			request.setAttribute("form", form);
			this.getServletContext().getRequestDispatcher("/WEB-INF/seconnecter.jsp").forward(request, response);
		}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
