package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Form;
import com.revature.pojos.User;
import com.revature.services.RformServices;
import com.revature.services.UserServices;

public class PendingServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession sess = req.getSession(true);
		String uName = (String) sess.getAttribute("username");
		String pass = (String) sess.getAttribute("password");
		User user = UserServices.login(new User(uName, pass));
		System.out.println(user.toString());
		try {
			ArrayList<Form> formList = null;
			formList = RformServices.getAllForms(user);
			System.out.println(formList);
			
			ObjectMapper om = new ObjectMapper();
			String formString = om.writeValueAsString(formList);
			String userString = om.writeValueAsString(user);
			StringBuilder sb = new StringBuilder(formString);
			if(formList.size() == 0)
				sb.insert(1, userString);
			else
				sb.insert(1, userString + ",");
			System.out.println(sb);
			resp.getWriter().append(sb);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
