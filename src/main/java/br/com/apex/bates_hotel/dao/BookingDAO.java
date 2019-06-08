package br.com.apex.bates_hotel.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.apex.bates_hotel.model.Booking;
import br.com.apex.bates_hotel.model.BookingStatus;

@Repository
public interface BookingDAO extends CrudRepository<Booking, Integer> {
	
	public List<Booking> findByStatus(BookingStatus status);

}
