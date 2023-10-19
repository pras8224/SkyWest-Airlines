package com.flight_reservation_app5.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.flight_reservation_app5.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {


//	@Query(value="select * from Flight where DEPARTURE_CITY=:departureCity and ARRIVAL_CITY=:arrivalCity and DATE_OF_DEPARTURE=:dateofDepartureDate" ,nativeQuery=true)
//	List<Flight> findFlights(@Param("departureCity") String from,@Param("arrivalCity") String to,@Param("dateofDepartureDate") Date departureDate);
	
	@Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
	List<Flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to,@Param("dateOfDeparture") Date departureDate);
}