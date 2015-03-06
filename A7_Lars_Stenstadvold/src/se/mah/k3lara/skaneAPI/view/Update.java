package se.mah.k3lara.skaneAPI.view;

public class Update extends Thread {
	private DeparturesGUI gui;
	
	private boolean running = true;
	
	public Update(DeparturesGUI gui2){
		this.gui = gui2;
	}
	
	public void run() {
		while (running == true){
			try{
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Updating!");
			gui.updateLines();
		}		
	}

}