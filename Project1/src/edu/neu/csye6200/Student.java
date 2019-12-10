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
		String guardianName;
		String guardianEmail;
		List<Date> immunisationDates = new ArrayList<>();
		
		
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
		
		public String getGuardianName() {
			return guardianName;
		}
		public void setGuardianName(String guardianName) {
			this.guardianName = guardianName;
		}
		public String getGuardianEmail() {
			return guardianEmail;
		}
		public void setGuardianEmail(String guardianEmail) {
			this.guardianEmail = guardianEmail;
		}
		public List<Date> getImmunisationDates() {
			return immunisationDates;
		}
		public void setImmunisationDates(List<Date> immunisationDates) {
			this.immunisationDates = immunisationDates;
		}
		
		
		public List<AbstractImmunization> getImmunisations() {
			return immunisations;
		}
		public void setImmunisations(List<AbstractImmunization> immunisations) {
			this.immunisations = immunisations;
		}
		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Student(int studentId, Date registrationDate, String address, String phoneNumber, String guardianName, String parentsEmail) {
			super();
			this.studentId = studentId;
			this.registrationDate = registrationDate;
			this.address = address;
			this.phoneNumber = phoneNumber;
			this.age = ConversionHelper.DateToAge(this.dob);
			this.guardianName = guardianName;
			this.guardianEmail = guardianEmail;
			
			for(int i = 0; i < 4; i++) {
				
			}
//			List<String> tempImmu = FileUtil.readTextFile(this.studentId+"immn.csv");
//			int flag = 0;
//			for(String s : tempImmu) {
//				String[] fields = s.split(",");
//				String n = fields[0];
//				//List<Date> d = new ArrayList<>();
//				for(int i = 1; i < fields.length-1; i++) {
//						d.add(ConversionHelper.StringToDate(fields[i]));
//				}
//				
//				if(flag == 0) {
//					immunisations.add(DTaPFactory.getInstance().getObject(n, d, this.age));
//				} else if(flag == 1) {
//					immunisations.add(RotavirusFactory.getInstance().getObject(n, d, this.age));
//				} else if(flag == 2) {
//					immunisations.add(HepatitisBFactory.getInstance().getObject(n, d, this.age));
//				} else if(flag == 3) {
//					immunisations.add(PneumococcalConjugateFactory.getInstance().getObject(n, d, this.age));
//				}
//				
//			}			
			
		}
		
		public Student(String csvData) {
 			super();
 			String[] field = csvData.split(",");
 			this.firstName  = field[0];
 			this.lastName  = field[1];
 			this.dob = ConversionHelper.StringToDate(field[2]);
 			this.studentId = ConversionHelper.StringToInt(field[3]);
 			this.registrationDate = ConversionHelper.StringToDate(field[4]);
 			this.address = field[5];
 			this.phoneNumber = field[6];
 			this.guardianName = field[7];
 			this.guardianEmail = field[8];
 			this.age = ConversionHelper.DateToAge(this.dob);
 			
 			int flag = 0;
 			List<Date> hepatitisB = new ArrayList<>();
 			List<Date> DTaP = new ArrayList<>();
 			List<Date> rotavirus = new ArrayList<>();
 			List<Date> pneumococcalConjugate = new ArrayList<>();
 			for(int i = 9; i < 22; i++) {
 				if(field[i].contentEquals("")) {
 					
 				} else {
 					if(i >= 9 && i < 12) {
 	 					hepatitisB.add(ConversionHelper.StringToDate(field[i]));
 	 				} 
 	 				if(i >= 12 && i < 16) {
 	 						DTaP.add(ConversionHelper.StringToDate(field[i]));
 	 				} 
 	 				if(i >= 16 && i < 19) {
 							rotavirus.add(ConversionHelper.StringToDate(field[i]));
 					} 
 	 				if(i >= 19 && i < 23) {
 						pneumococcalConjugate.add(ConversionHelper.StringToDate(field[i]));
 				}	
 				}
 				 
 			}

			immunisations.add(DTaPFactory.getInstance().getObject("DTaP",DTaP,this.age));
			immunisations.add(RotavirusFactory.getInstance().getObject("Rotavirus", rotavirus, this.age));
			immunisations.add(HepatitisBFactory.getInstance().getObject("Hepatitis B",hepatitisB, this.age));
			immunisations.add(PneumococcalConjugateFactory.getInstance().getObject("Pneumococcal Conjugate",pneumococcalConjugate, this.age));
					
		}
		
		
		@Override
		public String toString() {
			return "Student [studentId=" + studentId + ", registrationDate=" + registrationDate + ", address=" + address
					+ ", phoneNumber=" + phoneNumber + ", age=" + age + "]";
		}
		
		
		
}
