package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

	private char status;
	private String body;
	private String observation;
	private Date hour;
	
	public Note(char status, String body, String observation) {
		this.status = status;
		this.body = body;
		this.observation = observation;
		this.hour = new Date();
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Date getHour() {
		return hour;
	}

	public void setHour(Date hour) {
		this.hour = hour;
	}

	@Override
	public String toString() {
		return "(" + status + ") " + body + " (" + sdf.format(hour) + ")";
	}
	
}
