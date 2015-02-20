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
		String stringAlarmHour;
		String stringAlarmMinute;
		if (hours<10) {
			stringAlarmHour = "0" + String.valueOf(alarmHour);
		}else{
			stringAlarmHour = String.valueOf(alarmHour);
		}
		if (minute<10){
			stringAlarmMinute = "0" + String.valueOf(alarmMinute);
		}else{
			stringAlarmMinute = String.valueOf(alarmMinute);
			
		}
		clockGUI.setAlarmText("alarm: " + stringAlarmHour + ":" + stringAlarmMinute);
		clockGUI.lblAlarmIcon.setVisible(true);
	}
	
	public void clearAlarm() {
		clockGUI.setAlarmText("alarm");
		clockGUI.alarm(false);
		alarmHour = 100; // eftersom det aldrig är kl 100 ;)
		alarmMinute = 100;
		clockGUI.lblAlarmIcon.setVisible(false);
	}

	@Override
	public void update(int hourIn, int minuteIn, int secondIn) {
		String time;
		String minute;
		String second;
		
		if(minuteIn<10){
			minute = "0" + String.valueOf(minuteIn);
		}else{
			minute = String.valueOf(minuteIn);
		}
		
		if(secondIn <10){
			second = "0" + String.valueOf(secondIn);
		}else{
			second = String.valueOf(secondIn);
		}
		
		time = String.valueOf(hourIn) + ":" + minute + ":" + second;
		clockGUI.setTextOnLabel(time);
		
		
		//
		if((alarmHour == hourIn) && (alarmMinute == minuteIn)){
			clockGUI.alarm(true);
		}
	}

}
	