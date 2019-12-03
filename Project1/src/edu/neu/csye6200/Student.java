package edu.neu.csye6200;

import java.util.Date;

public class Student extends AbstractPerson {
		int studentId;
		Date registrationDate;
		String address;
		String phoneNumber;
		Immunization immu;
		
		public int getStudentId() {
			return studentId;
		}
		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}
		public Date getRegistrationDate() {
			return registrationDate;
		}
		public void setRegistrationDate(Date registrationDate) {
			this.registrationDate = registrationDate;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public Immunization getImmu() {
			return immu;
		}
		public void setImmu(Immunization immu) {
			this.immu = immu;
		}
		
		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Student(int studentId, Date registrationDate, String address, String phoneNumber, Immunization immu) {
			super();
			this.studentId = studentId;
			this.registrationDate = registrationDate;
			this.address = address;
			this.phoneNumber = phoneNumber;
			this.immu = immu;
		}
		
		public Student(String csvData) {
			super();
		}
		
		
		@Override
		public String toString() {
			return "Student [studentId=" + studentId + ", registrationDate=" + registrationDate + ", address=" + address
					+ ", phoneNumber=" + phoneNumber + ", immu=" + immu + "]";
		}
		
		
		
}
