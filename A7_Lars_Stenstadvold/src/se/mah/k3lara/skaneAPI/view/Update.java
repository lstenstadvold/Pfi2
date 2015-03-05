package se.mah.k3lara.skaneAPI.view;

import java.util.Calendar;

public class Update extends Thread {
	private DeparturesGUI gui;
	
	private boolean running = true;
	
	public Update(DeparturesGUI gui2){
		this.gui = gui2;
	}
	
	public void run() {
		while (running == true){
			try{
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Updating!");
			gui.updateLines();
		}		
	}

}