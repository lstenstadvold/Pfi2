package clock;

import java.util.Calendar;

public class ClockThread extends Thread
	implements ClockInterface{
	
	ClockInterface clockInterface;

	ClockThread(ClockInterface ci){
		clockInterface = ci;
	}
	
	@Override
	public void update(int hours, int minute, int second) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	   public void run() {
		   while (true) {
			   Thread.sleep(900);
			   clockInterface.update(Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), 
						   Calendar.getInstance().get(Calendar.SECOND)); 
			   }
		  
	   }
}

	

