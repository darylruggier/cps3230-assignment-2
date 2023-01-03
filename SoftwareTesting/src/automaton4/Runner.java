package automaton4;

import java.util.Random;

public class Runner {
	int postedAlertIconType;
	int visibleAlertIconType;
	int visibleAlerts = 1; // setting this to 1 by default as it is assumed that to be in the starting state the user is an admin of marketalertum and logged in and posted an alert of icon type n.
	
	public void viewAlert_correctAlertType() {
		this.visibleAlerts = 1;
		this.postedAlertIconType = 1;
		this.visibleAlertIconType = 1;
	}
	
	public void viewAlert_mismatchingAlertType() {
		this.visibleAlerts = 1;
		this.postedAlertIconType = 2;
		this.visibleAlertIconType = 3;
	}
	
	public void viewAlert_alertNotFound() {
		this.visibleAlerts = 0;
	}
	
	
	public void run() {
		final Random rand = new Random();
		final int randomNumber = rand.nextInt(3);
		System.out.println(randomNumber);
		
		if (randomNumber == 3) {
			this.viewAlert_correctAlertType();
		} else if (randomNumber == 2) {
			this.viewAlert_mismatchingAlertType();
		} else if (randomNumber == 1) {
			this.viewAlert_alertNotFound();
		}
	}
	
	
	
	public static void main(String[] args) {
		Runner runner = new Runner();
		runner.run();

	}

}
