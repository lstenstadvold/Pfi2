package clock;

import java.util.Calendar;

public class ClockThread extends Thread
	implements ClockInterface{
	
	private ClockInterface clockInterface;
	
	public ClockThread(ClockInterface ci){
		this.clockInterface = ci;
	}
	
	@Override
	public void update(int hours, int minute, int second) {
		// TODO Auto-generated method stub
	}
	
	@Override
	   public void run() {
		   while (true) {
			   clockInterface.update(Calendar.getInstance().get(Calendar.HOUR_OF_DAY), 
					   Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND));
			   try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		   }
		  
	   }
}

	

