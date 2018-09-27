package com.revature.pojos;

import java.sql.Date;

public class Form {
		private int formID;
		private double cost;
		private double amount;
		private String location;
		private String eventType;
		private String details;
		private String justification;
		private String status;
		private Date eventDate;
		private Date currDate;
		private String grade;
		private String userName;
		private String notes;  
		
		public Form() {}
		
		public Form(int formID, double cost, double amount, String loc, String eventType, 
				String details, String justification, String status, Date eventDate, String grade,
				String uName) {
			this.formID = formID;
			this.cost = cost;
			this.amount = amount;
			this.location = loc;
			this.eventType = eventType;
			this.details = details;
			this.justification = justification;
			this.status = status;
			this.eventDate = eventDate;
			java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
			this.currDate = date;
			this.grade = grade;
			this.setUserName(uName);
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

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getEventType() {
			return eventType;
		}

		public void setEventType(String eventType) {
			this.eventType = eventType;
		}

		public String getDetails() {
			return details;
		}

		public void setDetails(String details) {
			this.details = details;
		}

		public String getJustification() {
			return justification;
		}

		public void setJustification(String justification) {
			this.justification = justification;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Date getEventDate() {
			return eventDate;
		}

		public void setEventDate(Date eventDate) {
			this.eventDate = eventDate;
		}

		public Date getCurrDate() {
			return currDate;
		}

		public void setCurrDate(Date currDate) {
			this.currDate = currDate;
		}

		public String getGrade() {
			return grade;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getNotes() {
			return notes;
		}

		public void setNotes(String notes) {
			this.notes = notes;
		}
		
}
