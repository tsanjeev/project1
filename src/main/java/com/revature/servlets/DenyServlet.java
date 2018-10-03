package com.revature.servlets;

import com.revature.pojos.Event;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.services.RformServices;

public class DenyServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession sess = req.getSession(false);
		
		if(sess == null){
			resp.sendRedirect("login");
		}
		
		else {
			
			String title = (String) sess.getAttribute("title");
			String formID = req.getQueryString();
			try {
				RformServices.updateStatus(Integer.parseInt(formID), Event.DENIED);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if("benco".equalsIgnoreCase(title) || "Department Head".equalsIgnoreCase(title) || "Supervisor".equalsIgnoreCase(title)){
				
				req.getRequestDispatcher("../admin.html").forward(req, resp);
			}
			else if("Employee".equals(title)){
				req.getRequestDispatcher("../employee.html").forward(req, resp);
			}
			else{
				resp.sendRedirect("../login.html");
			}
		}
	}
}
