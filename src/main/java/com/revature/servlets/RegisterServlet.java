package com.revature.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pojos.Event;
import com.revature.pojos.Form;
import com.revature.pojos.User;
import com.revature.services.RformServices;
import com.revature.services.UserServices;

public class RegisterServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		HttpSession sess = req.getSession(false);
		
		if(sess == null){
			resp.sendRedirect("login");
		} else {
			User user = UserServices.login(new User((String)sess.getAttribute("username"), (String) sess.getAttribute("password")));
			Form form = new Form();
			form.setEmployeeID(user.getEmployeeID());
			form.setFirstname(user.getFirstName());
			form.setLastname(user.getLastName());
			form.setLocation(req.getParameter("location"));
			form.setDescription(req.getParameter("description"));
			if(user.getTitle().equals("Employee")) {
				form.setStatus(Event.PSA);
			} else if(user.getTitle().equals("Supervisor")) {
				form.setStatus(Event.PDH);
			} else if(user.getTitle().equals("Department Heard") || user.getTitle().equals("BenCo")) {
				form.setStatus(Event.PBA);
			}
			long millis=System.currentTimeMillis();  
			java.sql.Date dateNow =new java.sql.Date(millis);  
			form.setCurrDate(dateNow.toString());
			form.setTime(req.getParameter("rform-time"));
			form.setState(req.getParameter("state"));
			form.setCity(req.getParameter("city"));
			form.setState(req.getParameter("state"));
			form.setZip("zip");
			form.setStartDate(req.getParameter("startdate"));
		
			form.setGrade(req.getParameter("rform-grade"));
			form.setEventType(req.getParameter("event"));
			form.setJustification(req.getParameter("justification"));
			form.setCost(Double.parseDouble(req.getParameter("cost")));
			double cost = form.getCost();
			double projected = 0;
			if(form.getEventType().equals("University Course"))
				projected = cost * Event.UNIVERSITY_COURSE;
			else if(form.getEventType().equals("Seminar"))
				projected = cost * Event.SEMINAR;
			else if(form.getEventType().equals("Certification Prep"))
				projected = cost * Event.CERT_PREP;
			else if(form.getEventType().equals("Certification"))
				projected = cost * Event.CERT;
			else if(form.getEventType().equals("Technical Training"))
				projected = cost * Event.TECH_TRAINING;
			else if(form.getEventType().equals("Other"))
				projected = cost * Event.OTHER;
			form.setProjected(projected);
			
			try {
				RformServices.addNewForm(form);
				resp.sendRedirect("employee");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
