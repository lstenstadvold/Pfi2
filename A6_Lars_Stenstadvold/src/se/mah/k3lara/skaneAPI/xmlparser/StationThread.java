package se.mah.k3lara.skaneAPI.xmlparser;

import java.util.ArrayList;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.view.GUI;

public class StationThread extends Thread {
	private GUI gui;

	public StationThread(GUI gui) {
		this.gui = gui;
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run(){
		
		ArrayList<Station> searchStations = new ArrayList<Station>(); 
		searchStations.addAll(Parser.getStationsFromURL(gui.textFieldStation.getText()));
		
		for (Station s: searchStations){
			//loops through the stations in searchStations and prints the name and number
			gui.textAreaStation.append(s.getStationName() +" number:" +s.getStationNbr() +"\n");
		}
	}

}
