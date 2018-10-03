package com.revature.pojos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

	User user;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		user = new User("testFirst", "testLast", "uName", "pass", "position", "dept");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testGetFirstName() {
		assertEquals("testFirst", user.getFirstName());
		
	}

	public void testSetFirstName() {
		user.setFirstName("newName");
		assertEquals("newName", user.getFirstName());
	}

	public void testGetLastName() {
		assertEquals("testLast", user.getLastName());
	}

	public void testSetLastName() {
		assertEquals("newLName", user.getLastName());
	}

	public void testGetUserName() {
		assertEquals("uName", user.getUserName());
	}
/*
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getAvailableReimbursement() {
		return availamt;
	}

	public void setAvailableReimbursement(double availableReimbursement) {
		this.availamt = availableReimbursement;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}*/
}
