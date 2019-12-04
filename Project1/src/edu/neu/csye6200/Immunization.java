package edu.neu.csye6200;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Immunization {
	Map<String, List<Date>> immunisations;

	public Immunization(Map<String, List<Date>> immunisations) {
		super();
		this.immunisations = immunisations;
	}

}
