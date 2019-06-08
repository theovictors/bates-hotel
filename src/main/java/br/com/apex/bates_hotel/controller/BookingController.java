package br.com.apex.bates_hotel.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.apex.bates_hotel.dao.BookingDAO;
import br.com.apex.bates_hotel.dao.RoomDAO;
import br.com.apex.bates_hotel.model.Room;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingDAO bookingDAO;
	@Autowired
	private RoomDAO roomDAO;
	
	// Mostra list.jsp apenas com os campos de seleção de data para fazer um POST
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView booking() throws ParseException {
		ModelAndView modelAndView = new ModelAndView("booking/list");
		
		System.out.println("Entrou /booking/list GET");
		
		return modelAndView;
	}
	
	// Mostra o list.jsp com a lista populada dos quartos disponíveis
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ModelAndView booking(String startDate, String endDate) throws ParseException {
		ModelAndView modelAndView = new ModelAndView("booking/list");
		
		System.out.println("Entrou /booking/list POST");
		
//		Iterable<Room> roomsFree = roomDAO.findFreeByStartDateAndEndDate(
//				new SimpleDateFormat("dd/MM/yyyy").parse("16/06/2019"),
//				new SimpleDateFormat("dd/MM/yyyy").parse("10/07/2019"));
		
		Iterable<Room> roomsFree = roomDAO.findFreeByStartDateAndEndDate(
			new SimpleDateFormat("dd/MM/yyyy").parse(startDate),
			new SimpleDateFormat("dd/MM/yyyy").parse(endDate)
		);
		
		
		for(Room room : roomsFree) {
			System.out.println(room);
		}
		
		modelAndView.addObject("roomsFreeList", roomsFree);
		
		return modelAndView;
	}
	
}
