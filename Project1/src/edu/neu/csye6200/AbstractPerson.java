package edu.neu.csye6200;

import java.util.*;

public abstract class AbstractPerson {
		public static int id;
		public String firstName;
		public String lastName;
		public Date dob;
		
//		public AbstractPerson() {
//			id++;
//		}
//		public int getId() {
//			return id;
//		}
//		public void setId(int id) {
//			this.id = id;
//		}
		
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
		public Date getDob() {
			return dob;
		}
		public void setDob(Date dob) {
			this.dob = dob;
		}
		
}
