package edu.neu.csye6200;

import java.util.*;

public class Teacher extends AbstractPerson{
		public int employeeId;
		public Date joiningDate;
		public List<Student> sList;
		
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
		public List<Student> getsList() {
			return sList;
		}
		public void setsList(List<Student> sList) {
			this.sList = sList;
		}
		
		public Teacher() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public String toString() {
			return "Teacher [employeeId=" + employeeId + ", joiningDate=" + joiningDate + ", sList=" + sList + "]";
		}
		
		
		
}
