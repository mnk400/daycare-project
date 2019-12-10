package edu.neu.csye6200.immunisations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import edu.neu.csye6200.*;

public abstract class AbstractImmunization {

	String immunizationName;
	List<Date> immuDate = new ArrayList<>();
	int age;
	public abstract void checkImmunization(Student s);
}
