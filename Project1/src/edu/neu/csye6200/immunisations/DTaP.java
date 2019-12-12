package edu.neu.csye6200.immunisations;

import java.util.Date;
import java.util.List;

import edu.neu.csye6200.*;

public class DTaP extends AbstractImmunization {

	DTaP(String name, List<Date> immuDate, int age) {
		this.immunizationName = name;
		this.immuDate = immuDate;
		this.age = age;
	}
	@Override
	public void checkImmunization(Student s) {
		// TODO Auto-generated method stub
		Mailer m = new Mailer( s.getGuardianEmail());
		if(immuDate.size() < 3 && this.age >= 6 && this.age <= 8) {
			m.setVaccine(this.immunizationName);
			m.setDose("3");
			m.setStudName(s.getFirstName() + " " + s.getLastName());
			m.setRecpName(s.getGuardianName());
			m.setPhoneNum(s.getPhoneNumber());
			m.sendImmunizationNotificationMail();
			
			
		} else if(immuDate.size() < 3 && this.age > 8) {
			m.setVaccine(this.immunizationName);
			m.setDose("3");
			m.setStudName(s.getFirstName() + " " + s.getLastName());
			m.setRecpName(s.getGuardianName());
			m.setPhoneNum(s.getPhoneNumber());
			m.sendImmunizationWarning();
			
			
		} else if(immuDate.size() == 3 && this.age >=15 && this.age<=18) {
			m.setVaccine(this.immunizationName);
			m.setDose("4");
			m.setStudName(s.getFirstName() + " " + s.getLastName());
			m.setRecpName(s.getGuardianName());
			m.setPhoneNum(s.getPhoneNumber());
			m.sendImmunizationNotificationMail();
		} else if(immuDate.size() == 3 && this.age >=18) {
			m.setVaccine(this.immunizationName);
			m.setDose("4");
			m.setStudName(s.getFirstName() + " " + s.getLastName());
			m.setRecpName(s.getGuardianName());
			m.setPhoneNum(s.getPhoneNumber());
			m.sendImmunizationWarning();
			
		}

	}
	
	public String printImmunization(Student s) {
		// TODO Auto-generated method stub
		
		if(immuDate.size() < 3 && this.age >= 6 && this.age <= 8) {
			return "Due: 3rd dose of DTaP";
		} else if(immuDate.size() < 3 && this.age > 8) {
			return "Overdue: 3rd dose of DTaP";
		} else if(immuDate.size() == 3 && this.age >=15 && this.age<=18) {
			return "Due: 4th dose of DTaP";
		} else if(immuDate.size() == 3 && this.age >=18) {
			return "Overdue: 4th dose of DTaP";
		}
		return "DTaP vaccine up to date"; 
	}

	
}
