package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class GroupHelper {

	static int currentTeacherIndexFlag = 0; 
	
	static List<Student> students = new ArrayList<>();
	static List<Teacher> teachers = new ArrayList<>();
	public static void groupMe() {
		

		
		
		List<String> tempStudents = FileUtil.readTextFile("students.csv");
		tempStudents.forEach(student -> students.add(new Student(student)));
	
		List<String> tempTeachers = FileUtil.readTextFile("teachers.csv");
		tempTeachers.forEach(teacher -> teachers.add(new Teacher(teacher)));
	
		List<Student> sixToTwelve = students.stream().filter(student -> student.getAge() >= 6 && student.getAge() <= 12).collect(Collectors.toList());
//		System.out.println("6to12");
//		System.out.println(sixToTwelve);
		List<Student> thirteenToTwentyfour = students.stream().filter(student -> student.getAge() >= 13 && student.getAge() <= 24).collect(Collectors.toList());
//		System.out.println("13t024");
//		System.out.println(thirteenToTwentyfour);
		List<Student> twentyfiveToThirtyFive = students.stream().filter(student -> student.getAge() >= 25 && student.getAge() <= 35).collect(Collectors.toList());
//		System.out.println("25to35");
//		System.out.println(twentyfiveToThirtyFive);
		List<Student> thirtySixToFortySeven = students.stream().filter(student -> student.getAge() >= 36 && student.getAge() <= 47).collect(Collectors.toList());
//		System.out.println("36to47");
//		System.out.println(thirtySixToFortySeven);
		List<Student> fortyEightToFiftyNine = students.stream().filter(student -> student.getAge() >= 48 && student.getAge() <= 59).collect(Collectors.toList());
		List<Student> sixtyAndUp = students.stream().filter(student -> student.getAge() >= 60).collect(Collectors.toList());
		//System.out.println("60");
		List<List<Student>> studentAgeGroups = new ArrayList<>();
		
		studentAgeGroups.add(sixToTwelve);
		studentAgeGroups.add(thirteenToTwentyfour);
		studentAgeGroups.add(twentyfiveToThirtyFive);
		studentAgeGroups.add(thirtySixToFortySeven);
		studentAgeGroups.add(fortyEightToFiftyNine);
		studentAgeGroups.add(sixtyAndUp);
		
		ListIterator<List<Student>> li = studentAgeGroups.listIterator();
		while(li.hasNext()) {
			List<Student> s = li.next();
			if(s.size() == 0) {
				li.remove();
			}
		}
		
		for(List<Student> s : studentAgeGroups) {
			System.out.println(s);
		}
		
	
		int flag = 0;
		while(flag < studentAgeGroups.size()) {
			
//			System.out.println(currentTeacherIndexFlag);
//			System.out.println(teachers.get(currentTeacherIndexFlag));
//			if(currentTeacherIndexFlag == teachers.size()) {
//				currentTeacherIndexFlag = 0;
//			}
//			
//			
			if(flag == 0) {
				System.out.println("calling 0");
				parseAndAdd(studentAgeGroups.get(flag), 4, 3);
			} else if(flag == 1) {
				System.out.println("calling 1");
				parseAndAdd(studentAgeGroups.get(flag), 5, 3);
			} else if(flag == 2) {
				System.out.println("calling 2");
				studentAgeGroups.get(flag);
				parseAndAdd(studentAgeGroups.get(flag), 6, 3);
			} else if(flag == 3) {
				System.out.println("calling 3");
				parseAndAdd(studentAgeGroups.get(flag), 8, 3);
			} else if(flag == 4) {
				System.out.println("calling 4");
				parseAndAdd(studentAgeGroups.get(flag), 12, 2);
			} else if(flag == 5) {
				parseAndAdd(studentAgeGroups.get(flag), 15, 2);
			}
			
			flag = flag + 1;

		}
		
		parseAddTeacher(teachers, Daycare.getClassroom());
		//System.out.println(Daycare.getClassroom());
		
		
		
		
	}
	
	public static void parseAndAdd(List<Student> studs, int size, int classSize) {
		System.out.println("i am  in parseaddstud");
		System.out.println(studs);
		System.out.println(size);
		int numGroups = 0;
		if(studs.size()%size == 0) {
			numGroups = studs.size()/size;
			
		} else {
			numGroups = studs.size()/size + 1;
		}
		List<Group> groups = new ArrayList<>();
		int temp=0;
		for(int i = 0; i < numGroups; i++) {
			groups.add(GroupFactory.getInstance().getObject());
			for(int j = 0; j < size; j++) {
				if((temp+j)<studs.size()) {
					groups.get(i).addStudents(studs.get(temp+j));
				}	
			}
			temp = temp + size;
		}
		
		List<Classroom> classes = new ArrayList<>();
		int tempC = 0;
		int numClassrooms = 0;
		if(groups.size()%classSize == 0) {
			numClassrooms = groups.size()/classSize;
			
		} else {
			numClassrooms = groups.size()/classSize + 1;
		}
		
		System.out.println("number of classrooms");
		System.out.println(groups.size());
		System.out.println(numClassrooms);
		for(int i = 0; i<numClassrooms; i++) {
			classes.add(ClassroomFactory.getInstance().getObject());
			for(int j = 0; j < classSize; j++) {
				if((tempC+j) < groups.size()) {
					classes.get(i).addGroups(groups.get(tempC + j));
				}
			}
			
			tempC = tempC + classSize;
		}
		
		classes.forEach(c -> Daycare.addClassroom(c));
		
	}
	
	
	public static void parseAddTeacher(List<Teacher> t, List<Classroom> c) {
		int currTF = 0;
		for(Classroom cl : c) {
			for(Group g : cl.getGroups()) {
				g.assignTeacher(t.get(currTF));
				System.out.println("i am  in parseaddteacher");
				System.out.println(g);
				System.out.println(t.get(currTF));
				currTF = currTF + 1;
				if(currTF == t.size()) {
					currTF = 0;
				}
			}
		}
		
	}
	
 
}
