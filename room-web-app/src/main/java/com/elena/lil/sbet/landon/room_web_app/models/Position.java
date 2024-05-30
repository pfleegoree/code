package com.elena.lil.sbet.landon.room_web_app.models;

public enum Position {
	
	HOUSEKEEPING, FRONT_DESK, SECURITY, CONSIERGE;
	
	public String toString() {
		switch (this) {
		
		case HOUSEKEEPING:
			return "Housekeeping";
			
		case FRONT_DESK:
			return "Front Desk";
			
		case SECURITY:
		return "Security";
			
		case CONSIERGE:
			return "Consierge";
		
		}
		return "";
		
		
	}

}
