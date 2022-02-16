package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

	private String status;
	private String body;
	private String observation;
	private Date hour;
	
	public Note(String status, String body, String observation) {
		this.status = status;
		this.body = body;
		this.observation = observation;
		this.hour = new Date();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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
