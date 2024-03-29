package edu.neu.csye6200.immunisations;
import java.util.Date;
import java.util.List;

import edu.neu.csye6200.*;
public class Rotavirus extends AbstractImmunization {

	Rotavirus(String name, List<Date> immuDate, int age) {
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
			
		} 
	}
	
	public String printImmunization(Student s) {
		// TODO Auto-generated method stub
		if(immuDate.size() < 3 && this.age >= 6 && this.age <= 8) {
			return "Due: 3rd dose of Rotavirus";
		} else if(immuDate.size() < 3 && this.age > 8) {
			return "Overdue: 3rd dose of Rotavirus";
		} 
		return "Rotavirus vaccine up to date";
	}

}
