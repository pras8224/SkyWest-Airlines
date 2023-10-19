package com.flight_reservation_app5.service;


import com.flight_reservation_app5.dto.ReservationRequest;
import com.flight_reservation_app5.entity.Reservation;


public interface ReservationService {
	Reservation bookFlight(ReservationRequest request);
}
