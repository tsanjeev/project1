package com.revature.services;

import java.util.ArrayList;

import com.revature.dao.RformDAOImp;
import com.revature.pojos.Event;
import com.revature.pojos.Form;
import com.revature.pojos.User;

public class RformServices {
	static RformDAOImp rd = new RformDAOImp();
	
	public static Form addNewForm(Form form) throws Exception {
		rd.formInsert(form);
		return form;
	}
	
	public static void updateStatus(int id, String title) throws Exception {
		
		Form form = rd.getAForm(id);		
		int approveLevel = 0;
		if("benco".equalsIgnoreCase(title))
			approveLevel = Event.BA;
		else if("Department Head".equalsIgnoreCase(title) && 
				(form.getStatus() == Event.PSA ||  form.getStatus() == Event.PDH)){
			approveLevel = Event.PBA;
		}
		else if("Supervisor".equalsIgnoreCase(title) && form.getStatus() == Event.PSA)
			approveLevel = Event.PDH;
		rd.formUpdateStatus(id, approveLevel);
		
	}
	
	public static void deleteUserSoft(Form form) throws Exception {
		rd.formDeleteSoft(form);
	}
	
	public static ArrayList<Form> getAllUserForms(User u) throws Exception {
		return rd.getAllFormsForUser(u);
	}
	
	public static ArrayList<Form> getAllForms(User u) throws Exception {
		return rd.getAllForms(u);
	}
	
}
