package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeServlet extends HttpServlet{
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
			HttpSession sess = req.getSession(false);
			
			if(sess == null){
				resp.sendRedirect("login");
			}
			
			else {
				String title = (String) sess.getAttribute("title");
				
				if("manager".equals(title)){
					req.getRequestDispatcher("manager.html").forward(req, resp);
				}
				else if("Employee".equals(title)){
					req.getRequestDispatcher("employee.html").forward(req, resp);
				}
				else{
					System.out.println("title: " + title);
					resp.sendRedirect("login.html");
				}
			}
		}
		
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
			doGet(req, resp);
		}
}
