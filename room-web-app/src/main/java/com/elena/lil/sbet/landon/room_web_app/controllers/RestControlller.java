package com.elena.lil.sbet.landon.room_web_app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elena.lil.sbet.landon.room_web_app.models.Room;
import com.elena.lil.sbet.landon.room_web_app.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RestControlller {
	private final RoomService roomService;

	public RestControlller(RoomService roomService) {
		super();
		this.roomService = roomService;
	}
	
	@GetMapping
	public List<Room> getAllRooms(){
	return roomService.getAllRooms();
	}

}
