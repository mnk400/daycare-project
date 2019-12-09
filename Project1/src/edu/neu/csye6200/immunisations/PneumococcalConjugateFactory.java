package edu.neu.csye6200.immunisations;

import java.util.Date;
import java.util.List;

public class PneumococcalConjugateFactory extends AbstractImmunizationFactory{

	private static PneumococcalConjugateFactory instance;
	private PneumococcalConjugateFactory() {
		instance = null;
	}
	public static PneumococcalConjugateFactory getInstance() {
		if(instance == null) {
			instance = new PneumococcalConjugateFactory();
		}
		
		return instance;
	}
	@Override
	public AbstractImmunization getObject(String name, List<Date> d, int age) {
		// TODO Auto-generated method stub
		return new PneumococcalConjugate(name, d, age);
	}

}
