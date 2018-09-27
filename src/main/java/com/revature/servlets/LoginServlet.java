package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pojos.User;
import com.revature.services.UserServices;

public class LoginServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession sess = req.getSession(false);
		
		if(sess == null || sess.getAttribute("title") == null){
			resp.sendRedirect("../login.html");
			System.out.println("inside doget login");
		}
		else {
			resp.sendRedirect("employee");
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String username = req.getParameter("usernamelog");
		String password = req.getParameter("passwordlog");
		
		
		User u = UserServices.login(new User(username, password));
		if (u != null) {
			System.out.println(u);
			HttpSession sess = req.getSession(true);
			sess.setAttribute("username", u.getUserName());
			sess.setAttribute("title", u.getTitle());
			resp.sendRedirect("employee");
			
		} else {
			resp.sendRedirect("login.html");
		}
	}

}
