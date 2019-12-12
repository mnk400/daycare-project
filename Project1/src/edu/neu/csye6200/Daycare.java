package edu.neu.csye6200;

import java.util.*;

//import edu.neu.csye6200.immunisations.*;

public class Daycare {
		private static List<Classroom> classList = new ArrayList<>();

		
		public static void addClassroom(Classroom c) {
			classList.add(c);
		}
		
		
		public static void show() {
			classList.forEach(c -> {System.out.println(); System.out.println(c);});
		}
		
		public static List<Classroom> getClassroom(){
			return classList;
		}

		
		
		public static void demo() {
			
			GroupHelper.groupMe();
			NotificationHelper.configureTask();
			Thread t = new ReviewNotifyTask();
			t.start();
			//Daycare.show();
			//loadImmunizationRules();
			
			
			
		}
//		
//		public static void setAnnualDates() {
//			//for(Student s : GroupHelper.students) {
//		//		NotificationHelper.configureTask(s.getAnnualRegistrationDate());
//		//	}
//			
//			
//		}
		
		
}
