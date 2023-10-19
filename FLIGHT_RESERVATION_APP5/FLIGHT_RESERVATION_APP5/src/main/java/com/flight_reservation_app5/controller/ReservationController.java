package com.flight_reservation_app5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flight_reservation_app5.dto.ReservationRequest;
import com.flight_reservation_app5.entity.Reservation;
import com.flight_reservation_app5.service.ReservationService;


@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/confirmReservation")
	public String confirmReservation(ReservationRequest request, ModelMap modelMap) {
		Reservation reservationId = reservationService.bookFlight(request);
		modelMap.addAttribute("reservationId", reservationId.getId());
		
//		System.out.println(request.getFlightId());
		return "confirmReservation";
	}

}
