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
	public void checkImmunization() {
		// TODO Auto-generated method stub
		if(immuDate.get(2) == null && this.age >= 6 && this.age <= 8) {
			System.out.println("Time for your third rotavirus dose");
		} else if(immuDate.get(2) == null && this.age > 8) {
			System.out.println("You must take your third rotavirus dose");
		} 
	}

}
