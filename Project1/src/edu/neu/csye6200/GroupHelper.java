package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GroupHelper {

	
	public static void groupMe() {
		
		List<Student> students = new ArrayList<>();
		List<Teacher> teachers = new ArrayList<>();
		
		List<String> tempStudents = FileUtil.readTextFile("StudentRecords.csv");
		tempStudents.forEach(student -> students.add(new Student(student)));
	
		List<String> tempTeachers = FileUtil.readTextFile("StudentRecords.csv");
		tempTeachers.forEach(teacher -> teachers.add(new Teacher(teacher)));
	
		List<Student> sixToTwelve = students.stream().filter(student -> student.getAge() >= 6 && student.getAge() <= 12).collect(Collectors.toList());
		List<Student> thirteenToTwentyfour = students.stream().filter(student -> student.getAge() >= 13 && student.getAge() <= 24).collect(Collectors.toList());
		List<Student> twentyfiveToThirtyFive = students.stream().filter(student -> student.getAge() >= 25 && student.getAge() <= 35).collect(Collectors.toList());
		List<Student> thirtySixToFortySeven = students.stream().filter(student -> student.getAge() >= 36 && student.getAge() <= 47).collect(Collectors.toList());
		List<Student> fortyEightToFiftyNine = students.stream().filter(student -> student.getAge() >= 48 && student.getAge() <= 59).collect(Collectors.toList());
		List<Student> sixtyAndUp = students.stream().filter(student -> student.getAge() >= 60).collect(Collectors.toList());
		
		int currentTeacherIndexFlag;
		
		
	}
	
	public static void parseAndAdd(List<Student> studs, Teacher t, int size) {
		
		int numGroups = studs.size()/size + 1;
		List<Group> groups = new ArrayList<>();
		int temp=0;
		for(int i = 0; i < numGroups; i++) {
			groups.add(GroupFactory.getInstance().getObject());
			groups.get(i).asssignTeacher(t);
			for(int j = 0; j < size; j++) {
				groups.get(i).addStudents(studs.get(temp+j));
			}
			temp = temp + size;
		}	
	}
	
	
 
}
