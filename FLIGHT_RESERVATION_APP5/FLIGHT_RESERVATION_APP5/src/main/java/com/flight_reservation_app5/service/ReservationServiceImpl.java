package com.flight_reservation_app5.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight_reservation_app5.dto.ReservationRequest;
import com.flight_reservation_app5.entity.Flight;
import com.flight_reservation_app5.entity.Passenger;
import com.flight_reservation_app5.entity.Reservation;
import com.flight_reservation_app5.repository.FlightRepository;
import com.flight_reservation_app5.repository.PassengerRepository;
import com.flight_reservation_app5.repository.ReservationRepository;
import com.flight_reservation_app5.utilities.EmailUtil;
import com.flight_reservation_app5.utilities.PDFGenerator;


@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private PDFGenerator pdfGenerator;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
//		String firstName = request.getFirstName();
//		String lastName = request.getLastName();
//		String middleName = request.getMiddleName();
//		String email = request.getEmail();
//		String phone = request.getPhone();
		
		
		
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);
		
		long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		
		Reservation reservation=new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		String filePath= "F:\\FLIGHT_RESERVATION_APP5\\FLIGHT_RESERVATION_APP5\\tickets\\reservation" +reservation.getId() +".pdf";
		reservationRepo.save(reservation);
		pdfGenerator.generateItinerary(reservation,filePath);
		emailUtil.sendItinerary(passenger.getEmail(),filePath);
//		String attachment=filePath +reservation.getId()+".pdf";
		return reservation;
	}

}
































