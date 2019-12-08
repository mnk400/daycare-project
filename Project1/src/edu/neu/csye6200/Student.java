package edu.neu.csye6200;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends AbstractPerson {
		int studentId;
		Date registrationDate;
		String address;
		String phoneNumber;
		//Immunization immu;
		int age;
		
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
//		public Immunization getImmu() {
//			return immu;
//		}
//		public void setImmu(Immunization immu) {
//			this.immu = immu;
//		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getAge() {
			return age;
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
			//this.immu = immu;
			this.age = ConversionHelper.DateToAge(this.dob);
		}
		
		public Student(String csvData) {
 			super();
 			String[] field = csvData.split(",");
 			this.id = ConversionHelper.StringToInt(field[0]);
 			this.firstName  = field[1];
 			this.lastName  = field[2];
 			this.dob = ConversionHelper.StringToDate(field[3]);
 			this.studentId = ConversionHelper.StringToInt(field[4]);
 			this.registrationDate = ConversionHelper.StringToDate(field[5]);
 			this.address = field[6];
 			this.phoneNumber = field[7];
 			//FileUtil.readTextFile("Immunization"+this.studentId+".csv");
 			this.age = ConversionHelper.DateToAge(this.dob);
		}
		
		
		@Override
		public String toString() {
			return "Student [studentId=" + studentId + ", registrationDate=" + registrationDate + ", address=" + address
					+ ", phoneNumber=" + phoneNumber + ", age=" + age + "]";
		}
		
		
		
}
