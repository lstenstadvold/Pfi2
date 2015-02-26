package se.mah.k3lara.skaneAPI.xmlparser;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.view.GUI;

public class StationThread extends Thread {

	public StationThread() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run(){
		String searchURL = Constants.getURL(textField_1.getText(),textField_2.getText(),1);
		Journeys journeys = Parser.getJourneys(searchURL);
	}

}
