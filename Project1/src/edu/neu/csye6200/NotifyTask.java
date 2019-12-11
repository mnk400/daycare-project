package edu.neu.csye6200;

import java.util.TimerTask;

public class NotifyTask extends TimerTask {
	
	Thread notificationThread;
	NotifyTask(Thread t) {
		this.notificationThread = t;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		notificationThread.start();

	}

}
