package clock;

public class ClockLogic 
	implements ClockInterface {
	
	DigitalClockGUI clockGUI;
	int alarmHour;
	int alarmMinute;
	
	
	public ClockLogic(DigitalClockGUI clockIn){
		clockGUI = clockIn;
		Thread t = new ClockThread(this);
		t.start();
	}
	
	public void setAlarm(int hours, int minute){
		
	}
	
	public void clearAlarm() {
		
	}

	@Override
	public void update(int hourIn, int minuteIn, int secondIn) {
	}
	
	
}