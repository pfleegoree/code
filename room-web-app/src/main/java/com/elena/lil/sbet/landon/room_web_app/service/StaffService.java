package com.elena.lil.sbet.landon.room_web_app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.elena.lil.sbet.landon.room_web_app.models.Position;
import com.elena.lil.sbet.landon.room_web_app.models.StaffMember;

@Service
public class StaffService {
	
	private static final List<StaffMember> staff = new ArrayList();
	
	static {
		staff.add(new StaffMember(UUID.randomUUID().toString(), "John", "Doe", Position.CONSIERGE));
		staff.add(new StaffMember(UUID.randomUUID().toString(), "Jane", "Doe", Position.FRONT_DESK));
		staff.add(new StaffMember(UUID.randomUUID().toString(), "Oliver", "Handle", Position.HOUSEKEEPING));
		staff.add(new StaffMember(UUID.randomUUID().toString(), "Sam", "Smith", Position.SECURITY));
	}
	public List <StaffMember> getAllStaff(){return staff;}

}
