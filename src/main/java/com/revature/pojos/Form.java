package com.revature.pojos;



public class Form {
		
		private int formID;
		private int employeeID;
		private String firstname;
		private String lastname;
		
		private String location;
		private String city;
		private String state;
		private String zip;
		private String description;
		
		private String currDate;
		private String startDate;
		private String time;
		private String event;
		private String justification;
		private int status;
		
		private String grade;
		private double cost; 
		private double projected;
		
		public Form() {}


		public Form(int formID, int employeeID, String firstname, String lastname, double cost, String loc, String eventType, 
				String details, String justification, int status, String eventDate, String time, String grade) {
			this.formID = formID;
			this.employeeID = employeeID;
			this.setFirstname(firstname);
			this.setLastname(lastname);
			this.cost = cost;
			this.location = loc;
			this.event = eventType;
			this.setTime(time);
			this.description = details;
			this.justification = justification;
			this.status = status;
			this.startDate = eventDate;
			this.grade = grade;
		}
		public int getFormID() {
			return formID;
		}

		public void setFormID(int formID) {
			this.formID = formID;
		}

		public double getCost() {
			return cost;
		}

		public void setCost(double cost) {
			this.cost = cost;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getEventType() {
			return event;
		}

		public void setEventType(String eventType) {
			this.event = eventType;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String details) {
			this.description = details;
		}

		public String getJustification() {
			return justification;
		}

		public void setJustification(String justification) {
			this.justification = justification;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getStartDate() {
			return startDate;
		}

		public void setStartDate(String eventDate) {
			this.startDate = eventDate;
		}

		public String getCurrDate() {
			return currDate;
		}

		public void setCurrDate(String currDate) {
			this.currDate = currDate;
		}

		public String getGrade() {
			return grade;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}


		public int getEmployeeID() {
			return employeeID;
		}

		public void setEmployeeID(int employeeID) {
			this.employeeID = employeeID;
		}


		public String getFirstname() {
			return firstname;
		}


		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}


		public String getLastname() {
			return lastname;
		}


		public void setLastname(String lastname) {
			this.lastname = lastname;
		}


		public String getTime() {
			return time;
		}


		public void setTime(String time) {
			this.time = time;
		}


		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getState() {
			return state;
		}


		public void setState(String state) {
			this.state = state;
		}


		public String getZip() {
			return zip;
		}


		public void setZip(String zip) {
			this.zip = zip;
		}


		public double getProjected() {
			return projected;
		}


		public void setProjected(double projected) {
			this.projected = projected;
		}

		
}
