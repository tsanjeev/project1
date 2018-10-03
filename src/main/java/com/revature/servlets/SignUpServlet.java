package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;
import com.revature.services.UserServices;

public class SignUpServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8327599451333501985L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String title = req.getParameter("title");
		String department = req.getParameter("department");
		User user = new User(firstname, lastname, username, password, title, department);
		try {
			UserServices.addNewUser(user);
			resp.sendRedirect("home");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
