package clock;

public class ClockLogic 
	implements ClockInterface {
	
	private DigitalClockGUI clockGUI;
	private int alarmHour;
	private int alarmMinute;
	
	public ClockLogic(DigitalClockGUI clockIn){
		clockGUI = clockIn;
		Thread t = new ClockThread(this);
		t.setName("ClockThread");
		t.start();
	}
	
	public void setAlarm(int hours, int minute){
		alarmHour = hours;
		alarmMinute = minute;
		clockGUI.lblAlarmAt.setText("alarm: " + String.valueOf(alarmHour) + ":" + String.valueOf(alarmMinute));
		
	}
	
	public void clearAlarm() {
	
	}

	@Override
	public void update(int hourIn, int minuteIn, int secondIn) {
		clockGUI.setTextOnLabel(String.valueOf(hourIn) + ":" + String.valueOf(minuteIn) + ":" + String.valueOf(secondIn));
	}
}
	