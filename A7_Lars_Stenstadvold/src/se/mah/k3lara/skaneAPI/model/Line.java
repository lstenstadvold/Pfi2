package se.mah.k3lara.skaneAPI.model;

import java.util.Calendar;

public class Line {
	private String line;
	private Calendar depTime;
	private String depTimeDeviation;
	private String stopPoint;
	private String lineTypeId;
	private String lineTypeName;
	private String towards;
	private String runNo;
	

	private String journeyDateTime;
	
	
	public Line() {
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public Calendar getDepTime() {
		return depTime;
	}
	public void setDepTime(Calendar depTime) {
		this.depTime = depTime;	
	}
	

	
	public String getDepTimeDeviation() {
		return depTimeDeviation;
	}
	public void setDepTimeDeviation(String depTimeDeviation) {
		this.depTimeDeviation = depTimeDeviation;
	}
	public String getStopPoint() {
		return stopPoint;
	}
	public void setStopPoint(String stopPoint) {
		this.stopPoint = stopPoint;
	}
	public String getLineTypeId() {
		return lineTypeId;
	}
	public void setLineTypeId(String lineTypeId) {
		this.lineTypeId = lineTypeId;
	}
	public String getLineTypeName() {
		return lineTypeName;
	}
	public void setLineTypeName(String lineTypeName) {
		this.lineTypeName = lineTypeName;
	}
	public String getTowards() {
		return towards;
	}
	public void setTowards(String towards) {
		this.towards = towards;
	}
	public String getRunNo() {
		return runNo;
	}
	public void setRunNo(String runNo) {
		this.runNo = runNo;
	}
	public void setJourneyDateTime(String journeyDateTime) {
		this.journeyDateTime = journeyDateTime;
			
	}
	
	public String getJourneyDateTime() {
		return journeyDateTime;
	}
	
	
	//And perhaps some special methods ????
	
}
