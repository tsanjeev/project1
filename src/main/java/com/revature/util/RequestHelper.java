package com.revature.util;

import javax.servlet.http.HttpServlet;

import com.revature.servlets.AboutServlet;
import com.revature.servlets.AdminServlet;
import com.revature.servlets.ApplyServlet;
import com.revature.servlets.EmployeeServlet;
import com.revature.servlets.GetInfoServlet;
import com.revature.servlets.HomeServlet;
import com.revature.servlets.LoginServlet;
import com.revature.servlets.LogoutServlet;
import com.revature.servlets.PageNotFoundServlet;
import com.revature.servlets.PendingServlet;
import com.revature.servlets.RegisterServlet;
import com.revature.servlets.SignUpServlet;

public class RequestHelper {

	private static HttpServlet homeServlet = new HomeServlet();
	private static HttpServlet loginServlet = new LoginServlet();
	private static HttpServlet pnfServlet = new PageNotFoundServlet();
	private static HttpServlet aboutServlet = new AboutServlet();
	private static HttpServlet employeeServlet = new EmployeeServlet();
	private static HttpServlet logoutServlet = new LogoutServlet();
	private static HttpServlet getInfoServlet = new GetInfoServlet();
	private static HttpServlet applyServlet = new ApplyServlet();
	private static HttpServlet registerServlet = new RegisterServlet();
	private static HttpServlet signupServlet = new SignUpServlet();
	private static HttpServlet adminServlet = new AdminServlet();
	private static HttpServlet pendingServlet = new PendingServlet();
	
	public HttpServlet dispatchRequest(String path) {

		System.out.println(path);
		
		HttpServlet nextServlet = null;

		switch (path) {
		
		case "/TRMS/app/pending":
			nextServlet = pendingServlet;
			System.out.println("pending");
			break;
		
		case "/TRMS/app/admin":
			nextServlet = adminServlet;
			System.out.println("admin");
			break;
		
		case "/TRMS/app/signup":
			nextServlet = signupServlet;
			System.out.println("signup");
			break;
			
		case "/TRMS/app/login":
			nextServlet = loginServlet;
			System.out.println("here");
			break;
		case "/TRMS/app/home":
			nextServlet = homeServlet;
			System.out.println("going home");
			break;
		case "/TRMS/app/about":
			nextServlet = aboutServlet;
			break;
		case"/TRMS/app/employee":
			nextServlet = employeeServlet;
			break;
		case "/TRMS/app/logout":
			nextServlet = logoutServlet;
			System.out.println("logout");
			break;
		case "/TRMS/app/getInfo":
			nextServlet = getInfoServlet;
			System.out.println("getinfo");
			break;
		case "/TRMS/app/apply":
			nextServlet = applyServlet;
			System.out.println("apply");
			break;
		case "/TRMS/app/register":
			nextServlet = registerServlet;
			System.out.println("register");
			break;
		default:
			nextServlet = pnfServlet;
			break;
		}

		return nextServlet;

	}

}
