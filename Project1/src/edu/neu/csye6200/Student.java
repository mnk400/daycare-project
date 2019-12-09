package edu.neu.csye6200;

import java.text.ParseException;
import edu.neu.csye6200.immunisations.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends AbstractPerson {
		int studentId;
		Date registrationDate;
		String address;
		String phoneNumber;
		private List<AbstractImmunization> immunisations = new ArrayList<>();
		
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
		
		public Student(int studentId, Date registrationDate, String address, String phoneNumber) {
			super();
			this.studentId = studentId;
			this.registrationDate = registrationDate;
			this.address = address;
			this.phoneNumber = phoneNumber;
			this.age = ConversionHelper.DateToAge(this.dob);
			List<String> tempImmu = FileUtil.readTextFile(this.studentId+"immn.csv");
			int flag = 0;
			for(String s : tempImmu) {
				String[] fields = s.split(",");
				String n = fields[0];
				List<Date> d = new ArrayList<>();
				for(int i = 1; i < fields.length-1; i++) {
						d.add(ConversionHelper.StringToDate(fields[i]));
				}
				
				if(flag == 0) {
					immunisations.add(DTaPFactory.getInstance().getObject(n, d, this.age));
				} else if(flag == 1) {
					immunisations.add(RotavirusFactory.getInstance().getObject(n, d, this.age));
				} else if(flag == 2) {
					immunisations.add(HepatitisBFactory.getInstance().getObject(n, d, this.age));
				} else if(flag == 3) {
					immunisations.add(PneumococcalConjugateFactory.getInstance().getObject(n, d, this.age));
				}
				
			}			
			
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
 			this.age = ConversionHelper.DateToAge(this.dob);
 			List<String> tempImmu = FileUtil.readTextFile(this.studentId+"immn.csv");
			int flag = 0;
			for(String s : tempImmu) {
				String[] fields = s.split(",");
				String n = fields[0];
				List<Date> d = new ArrayList<>();
				for(int i = 1; i < fields.length-1; i++) {
						d.add(ConversionHelper.StringToDate(fields[i]));
				}
				if(flag == 0) {
					immunisations.add(DTaPFactory.getInstance().getObject(n, d, this.age));
				} else if(flag == 1) {
					immunisations.add(RotavirusFactory.getInstance().getObject(n, d, this.age));
				} else if(flag == 2) {
					immunisations.add(HepatitisBFactory.getInstance().getObject(n, d, this.age));
				} else if(flag == 3) {
					immunisations.add(PneumococcalConjugateFactory.getInstance().getObject(n, d, this.age));
				}
				
			}			
		}
		
		
		@Override
		public String toString() {
			return "Student [studentId=" + studentId + ", registrationDate=" + registrationDate + ", address=" + address
					+ ", phoneNumber=" + phoneNumber + ", age=" + age + "]";
		}
		
		
		
}
