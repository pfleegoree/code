package com.elena.lil.sbet.landon.room_web_app.models;



public class StaffMember {
	private String employeeID;
	private String firstName;
	private String lastName;
	private Position position;
	
	public StaffMember() {
		super();
	}

	public StaffMember(String employeeID, String firstName, String lastName, Position position) {
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	
	
	


	
	
	
	

}
