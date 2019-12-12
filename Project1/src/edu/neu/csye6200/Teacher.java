package edu.neu.csye6200;

import java.util.*;

public class Teacher extends AbstractPerson{
		private int employeeId;
		private Date joiningDate;
		private Date annualReviewDate;
		private String emailID;
		
		public int getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}
		public Date getJoiningDate() {
			return joiningDate;
		}
		public void setJoiningDate(Date joiningDate) {
			this.joiningDate = joiningDate;
		}

		
		public String getEmailID() {
			return emailID;
		}
		public void setEmailID(String emailID) {
			this.emailID = emailID;
		}
		public Date getAnnualReviewDate() {
			return annualReviewDate;
		}
		public void setAnnualReviewDate(Date annualReviewDate) {
			this.annualReviewDate = annualReviewDate;
		}
		public Teacher() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Teacher(int employeeId, Date joiningDate) {
			super();
			this.employeeId = employeeId;
			this.joiningDate = joiningDate;
			Calendar c = Calendar.getInstance();
			c.setTime(this.joiningDate);
			c.add(c.WEEK_OF_YEAR, 51);
			this.annualReviewDate = c.getTime();
		}
		
		public Teacher(String csvData) {
			super();
 			String[] field = csvData.split(",");
 			this.firstName  = field[0];
 			this.lastName  = field[1];
 			this.dob = ConversionHelper.StringToDate(field[2]);
 			this.employeeId = ConversionHelper.StringToInt(field[3]);
 			this.joiningDate = ConversionHelper.StringToDate(field[4]);
 			this.emailID = field[5];
 			Calendar c = Calendar.getInstance();
			c.setTime(this.joiningDate);
			//c.add(c.WEEK_OF_YEAR, 51);
			c.add(c.YEAR, 1);
			this.annualReviewDate = c.getTime();
		}
		
		@Override
		public String toString() {
			return this.firstName + " " + this.lastName;
		}
		
		
		
}
