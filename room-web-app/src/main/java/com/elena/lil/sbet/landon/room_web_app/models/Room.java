package com.elena.lil.sbet.landon.room_web_app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ROOM")
public class Room {
	@Id
	@Column(name="ROOM_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
	@Column(name="ROOM_NUMBER")
	private String number;
	@Column(name="NAME")
	private String name;
	@Column(name="BED_INFO")
	private String info;
	
	
	public Room() {
		
	}


	public Room(long id, String number, String name, String info) {
		
		this.id = id;
		this.number = number;
		this.name = name;
		this.info = info;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
	
	
	
	

}
