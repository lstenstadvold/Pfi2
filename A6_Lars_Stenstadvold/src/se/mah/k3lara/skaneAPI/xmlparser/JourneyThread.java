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
		
		String searchURL = Constants.getURL(gui.textField_1.getText(),gui.textField_2.getText(),1);//Malm� C = 80000,  Lund C, 81216 Malm� Gatorg 80100, H�ssleholm C 93070
		Journeys journeys = Parser.getJourneys(searchURL);
		
		for (Journey journey : journeys.getJourneys()) {
			gui.textAreaJourneys.append(journey.getStartStation()+" - " + journey.getEndStation());
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
