package edu.neu.csye6200;

import java.util.TimerTask;

import edu.neu.csye6200.immunisations.AbstractImmunization;


public class NotifyTask extends TimerTask {
	
	Thread notificationThread;
	NotifyTask(Thread t) {
		this.notificationThread = t;
	}
	
	NotifyTask() {
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("Started running");
		//notificationThread.start();
		for(Student s : GroupHelper.students) {
			for(AbstractImmunization i : s.getImmunisations()) {
				i.checkImmunization(s);
			}
		}

	}

}
