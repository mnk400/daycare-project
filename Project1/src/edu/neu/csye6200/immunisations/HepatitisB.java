package edu.neu.csye6200.immunisations;

import java.util.Date;
import java.util.List;
import edu.neu.csye6200.*;

public class HepatitisB extends AbstractImmunization{

	HepatitisB(String name, List<Date> immuDate, int age) {
		this.immunizationName = name;
		this.immuDate = immuDate;
		this.age = age;
	}
	@Override
	public void checkImmunization(Student s) {
		if(immuDate.get(2) == null && this.age >= 15) {
			Mailer m = new Mailer("daycarecsye6200pmv@gmail.com", s.getGuardianEmail());
			m.setVaccine(this.immunizationName);
			m.setDose("3");
			m.setStudName(s.getFirstName() + s.getLastName());
		} else if(immuDate.get(2) == null && this.age < 15) {
			System.out.println("Lagwane ka time aagya hai");
		} 
	}

}
