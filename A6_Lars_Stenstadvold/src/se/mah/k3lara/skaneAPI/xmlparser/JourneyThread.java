package se.mah.k3lara.skaneAPI.xmlparser;

import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.view.GUI;

public class JourneyThread extends Thread {
	
	private GUI gui;

	public JourneyThread(GUI gui) {
		this.gui = gui;
		// TODO Auto-generated constructor stub
	}

	public void run(){
		//takes in text from GUI - from-station code and to-station code, and returns 1 search result
		String searchURL = Constants.getURL(gui.textFieldFrom.getText(),gui.textFieldTo.getText(),1);//Malm� C = 80000,  Lund C, 81216 Malm� Gatorg 80100, H�ssleholm C 93070
		Journeys journeys = Parser.getJourneys(searchURL);
		
		//loops through the list (that is one item long) that is parsed from getJourneys(searchURL) and prints 
		//all available information
		for (Journey journey : journeys.getJourneys()) {
			gui.textAreaJourneys.setText(journey.getStartStation()+" - " + journey.getEndStation());
			String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)+":"+journey.getDepDateTime().get(Calendar.MINUTE);
			
			gui.textAreaJourneys.append(" Departs " + time +" that is in "+journey.getTimeToDeparture()+ " minutes. And it is "+journey.getDepTimeDeviation()+" min late\n");
			gui.textAreaJourneys.append("Arrival time: " + journey.getArrDateTime().get(Calendar.HOUR_OF_DAY) +":"+journey.getArrDateTime().get(Calendar.MINUTE) + "\n");
			gui.textAreaJourneys.append("Nr of changes: " + journey.getNoOfChanges() + "\n");
			gui.textAreaJourneys.append("Line: " + journey.getLineOnFirstJourney() + "\n");
			gui.textAreaJourneys.append("Travel time: " + journey.getTravelMinutes() + " min \n");
			gui.textAreaJourneys.append("Nr of zones: " + journey.getNoOfZones() + "\n");
			gui.textAreaJourneys.append("Arrival time deviation: " + journey.getArrTimeDeviation() + " min \n");
		}
		
	}

}
