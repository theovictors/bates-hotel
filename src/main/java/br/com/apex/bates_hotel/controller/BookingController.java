package br.com.apex.bates_hotel.controller;

import java.util.Date;
import java.util.List;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.apex.bates_hotel.dao.BookingDAO;
import br.com.apex.bates_hotel.dao.RoomDAO;
import br.com.apex.bates_hotel.model.Booking;
import br.com.apex.bates_hotel.model.BookingStatus;
import br.com.apex.bates_hotel.model.Room;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingDAO bookingDAO;
	@Autowired
	private RoomDAO roomDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView booking() {
		ModelAndView modelAndView = new ModelAndView("booking/list");

		
		return modelAndView;
	}
	
}
