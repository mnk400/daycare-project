package edu.neu.csye6200.immunisations;

import java.util.Date;
import java.util.List;

public class RotavirusFactory extends AbstractImmunizationFactory {

	private static RotavirusFactory instance;
	private RotavirusFactory() {
		instance = null;
	}
	public static RotavirusFactory getInstance() {
		if(instance == null) {
			instance = new RotavirusFactory();
		}
		
		return instance;
	}
	@Override
	public AbstractImmunization getObject(String name, List<Date> d, int age) {
		// TODO Auto-generated method stub
		return new Rotavirus(name, d, age);
	}

}
