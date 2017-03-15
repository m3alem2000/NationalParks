package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("tempPreference")
public class HomeController {
	
	@Autowired
//	private ParkDao parkDao;
	
	@RequestMapping(path={"/", "/home"})
	public String showHomePage() {
		return "home";
	}
	
//	@RequestMapping(path={"/", "/home"}, method=RequestMethod.GET)
//	public String showHomePage(HttpServletRequest request) {
//		List<Park> parkList = parkDao.getAllParks();
//		request.setAttribute("parks", parkList);
//		return "home";
//	}
	
//	@RequestMapping(path={"/parkInfo"}, method=RequestMethod.GET)
//	public String showParkInfoPage(HttpServletRequest request, @RequestParam String parkCode) {
//		request.setAttribute("park", parkDao.getParkByParkCode(parkCode));
//		return "parkInfo";
//	}

}
