package com.techelevator.npgeek.controller;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.parks.model.Park;
import com.techelevator.npgeek.parks.model.ParkDAO;
import com.techelevator.npgeek.parks.model.Survey;
import com.techelevator.npgeek.parks.model.SurveyDAO;

@Controller
@SessionAttributes("tempPreference")
public class HomeController {
	
	@Autowired
	private ParkDAO parkDao;
	@Autowired
	private SurveyDAO surveyDao;
	
	@RequestMapping(path={"/", "/home"}, method=RequestMethod.GET)
	public String showHomePage(HttpServletRequest request) {
		List<Park> parkList = parkDao.getAllParks();
		request.setAttribute("parks", parkList);
		return "home";
	}
	
	@RequestMapping(path={"/parkDetail"}, method=RequestMethod.GET)
	public String showParkInfoPage(HttpServletRequest request, @RequestParam String parkCode) {
		request.setAttribute("park", parkDao.getParkByParkCode(parkCode));
		return "parkDetail";
	}
	
	@RequestMapping(path={"/survey"}, method=RequestMethod.GET)
	public String showSurveyPage(HttpServletRequest request) {
		List<Park> parkList = parkDao.getAllParks();
		request.setAttribute("parks", parkList);
		return "survey";
	}
	
	@RequestMapping(path={"/survey"}, method=RequestMethod.POST)
	public String addSurveyToDB(Survey theSurvey) {
		surveyDao.addSurvey(theSurvey);
		return "redirect:/home";
	}

}