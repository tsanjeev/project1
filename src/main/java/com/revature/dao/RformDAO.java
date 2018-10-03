package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojos.Form;
import com.revature.pojos.User;

public interface RformDAO {
	void formInsert(Form form) throws Exception;
	void formDeleteSoft(Form form) throws Exception;
	void formDeleteHard(Form form) throws Exception;
	void formUpdateStatus(int id, int status) throws Exception;
	Form getAForm(int id) throws Exception;
	ArrayList<Form> getAllForms(User user) throws Exception;
	ArrayList<Form> getAllFormsForUser(User user) throws Exception;
}
