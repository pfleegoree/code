package com.elena.lil.learningspring.util;

import java.util.Date;
import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.elena.lil.learningspring.business.ReservationService;
import com.elena.lil.learningspring.business.RoomReservation;
/*import com.elena.lil.learningspring.data.Guest;
import com.elena.lil.learningspring.data.GuestRepository;
import com.elena.lil.learningspring.data.Reservation;
import com.elena.lil.learningspring.data.ReservationRepository;
import com.elena.lil.learningspring.data.Room;
import com.elena.lil.learningspring.data.RoomRepository;*/

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent>{
	
	/*
	 * private final RoomRepository roomRepository; private final GuestRepository
	 * guestRepository; private final ReservationRepository reservationRepository;
	 */
	
	private final ReservationService reservationService;
	private final DateUtils dateUtils;
	

	/*
	 * public AppStartupEvent(RoomRepository roomRepository, GuestRepository
	 * guestRepository, ReservationRepository reservationRepository) {
	 * 
	 * this.roomRepository = roomRepository; this.guestRepository = guestRepository;
	 * this.reservationRepository = reservationRepository; }
	 */


	public AppStartupEvent(ReservationService reservationService, DateUtils dateUtils) {
		this.reservationService = reservationService;
		this.dateUtils = dateUtils;
	}


	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		Date date = this.dateUtils.createDateFromDateString("2022-01-01"); 
		List<RoomReservation> reservations = this.reservationService.getRoomReservationsForDate(date);
		reservations.forEach(System.out::println);

	}

	/*
	 * @Override public void onApplicationEvent(ApplicationReadyEvent event) {
	 * Iterable<Room> rooms = this.roomRepository.findAll();
	 * rooms.forEach(System.out::println); Iterable<Guest> guests =
	 * this.guestRepository.findAll(); guests.forEach(System.out::println);
	 * Iterable<Reservation> reservations = this.reservationRepository.findAll();
	 * reservations.forEach(System.out::println); }
	 */
	

}
