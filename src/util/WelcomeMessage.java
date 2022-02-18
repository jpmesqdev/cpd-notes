package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WelcomeMessage {
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	
	@SuppressWarnings("deprecation")
	private static int hour = new Date().getHours();

	private WelcomeMessage() {}
	
	public static String getMessage() {
		if (hour < 12.0) {
			return "Bom dia!";
		} else if (hour > 12.0 && hour < 18.0) {
			return "Boa tarde!";
		} else {
			return "Boa noite!";
		}
	}
}
