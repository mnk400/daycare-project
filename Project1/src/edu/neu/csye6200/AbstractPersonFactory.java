package edu.neu.csye6200;

public abstract class AbstractPersonFactory {

	public abstract AbstractPerson getObject(String csvData);
	
	public abstract AbstractPerson getObject();
}
