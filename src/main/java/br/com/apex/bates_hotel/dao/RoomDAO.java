package br.com.apex.bates_hotel.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.apex.bates_hotel.model.Room;

@Repository
public interface RoomDAO extends CrudRepository<Room, Integer> {
	
	@Query("SELECT r from Room r LEFT JOIN r.bookings b "
			+ "WHERE "
			+ "r.bookings IS EMPTY OR "
			+ "((b.startDate > :endDate AND b.endDate > :endDate) OR "
			+ "(b.endDate < :startDate AND b.startDate < :startDate))")
	public List<Room> findFreeByStartDateAndEndDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
}
