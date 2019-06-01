package br.com.apex.bates_hotel.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.apex.bates_hotel.dao.RoomDAO;
import br.com.apex.bates_hotel.model.Room;
import br.com.apex.bates_hotel.model.RoomType;

@Controller
@Transactional
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomDAO roomDAO;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createForm() {
		ModelAndView modelAndView = new ModelAndView("room/form");

		modelAndView.addObject("types", RoomType.values());

		return modelAndView;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createRoom(Room room) {
		ModelAndView modelAndView = new ModelAndView("redirect:/room/list");

		roomDAO.save(room);
		
		return modelAndView;
	}
	
	@RequestMapping("/list")
	public ModelAndView listRooms() {
		ModelAndView modelAndView = new ModelAndView("/room/list");
		
		modelAndView.addObject("roomsList", roomDAO.findAll());
		
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView room(Integer id) {
		ModelAndView modelAndView = new ModelAndView("/room/form");
		
		modelAndView.addObject("room", roomDAO.findOne(id));
		
		return modelAndView;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(Integer id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/room/list");
		
		roomDAO.delete(id);
		
		return modelAndView;
	}
	
	
}
