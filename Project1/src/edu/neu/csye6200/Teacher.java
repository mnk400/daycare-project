package edu.neu.csye6200;

import java.util.*;

public class Teacher extends AbstractPerson{
		public int employeeId;
		public Date joiningDate;
		
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

		
		public Teacher() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Teacher(int employeeId, Date joiningDate) {
			super();
			this.employeeId = employeeId;
			this.joiningDate = joiningDate;
		}
		
		public Teacher(String csvData) {
			super();
 			String[] field = csvData.split(",");
 			this.firstName  = field[0];
 			this.lastName  = field[1];
 			this.dob = ConversionHelper.StringToDate(field[2]);
 			this.employeeId = ConversionHelper.StringToInt(field[3]);
 			this.joiningDate = ConversionHelper.StringToDate(field[4]);
		}
		
		@Override
		public String toString() {
			return this.firstName + this.lastName;
		}
		
		
		
}
