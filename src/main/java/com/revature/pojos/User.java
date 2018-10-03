package com.revature.pojos;

public class User {
		
		private int employeeID;
		private String firstName;
		private String lastName;
		private String userName;
		private String passWord;
		private String title;
		private String department;
		private double availamt;


		public User() {}	
	
		public User(String username, String password) {
			this.userName = username;
			this.passWord = password;
		}
		
		public User(String fName, String lName, String uName, String passWord, String position, 
				String dept) {
			this.setFirstName(fName);
			this.setLastName(lName);
			this.setUserName(uName);
			this.setPassWord(passWord);
			this.setTitle(position);
			this.setDepartment(dept);
			this.setAvailableReimbursement(Event.TOTAL_AVAIL);
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getUserName() {
			return userName;
		}

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
		}

		@Override
		public String toString() {
			return "User [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", userName=" + userName + ", passWord=" + passWord + ", title=" + title + ", department="
					+ department + ", availamt=" + availamt + "]";
		}

		
		
		
}