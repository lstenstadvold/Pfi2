package clock;

public class ClockLogic 
	implements ClockInterface {
	
	private DigitalClockGUI clockGUI;
	private int alarmHour;
	private int alarmMinute;
	//private String timeTest;
	
	public ClockLogic(DigitalClockGUI clockIn){
		this.clockGUI = clockIn;
		Thread t = new ClockThread(this);
		t.setName("ClockThread");
		t.start();
	}
	
	public void setAlarm(int hours, int minute){
		alarmHour = hours;
		alarmMinute = minute;
		clockGUI.setAlarmText("alarm: " + String.valueOf(alarmHour) + ":" + String.valueOf(alarmMinute));
		
	}
	
	public void clearAlarm() {
	
	}

	@Override
	public void update(int hourIn, int minuteIn, int secondIn) {
		//setTimeTest(String.valueOf(hourIn) + ":" + String.valueOf(minuteIn) + ":" + String.valueOf(secondIn));
		String time = String.valueOf(hourIn) + ":" + String.valueOf(minuteIn) + ":" + String.valueOf(secondIn);
		clockGUI.setTextOnLabel(time);
		//clockGUI.setTextOnLabel(String.valueOf(hourIn) + ":" + String.valueOf(minuteIn) + ":" + String.valueOf(secondIn));
	}
/**
 * I've been trying every way my tiny brain can think of to solve this nullpointer but I reall don't get it :(
 * It seems like the thread is working, I just can't get it to update the way it should.
	public String getTimeTest() {
		return timeTest;
	}

	public void setTimeTest(String timeTestIn) {
		this.timeTest = timeTestIn;
	}
**/
}
	