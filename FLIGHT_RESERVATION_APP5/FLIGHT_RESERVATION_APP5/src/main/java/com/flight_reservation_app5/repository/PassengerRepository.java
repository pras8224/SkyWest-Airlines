package com.flight_reservation_app5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight_reservation_app5.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long>{

}
