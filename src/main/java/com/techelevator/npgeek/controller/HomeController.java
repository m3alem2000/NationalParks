package com.techelevator.npgeek.controller;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
import com.techelevator.npgeek.parks.model.Weather;
import com.techelevator.npgeek.parks.model.WeatherDAO;

@Controller
@SessionAttributes("tempPreference")
public class HomeController {
	
	@Autowired
	private ParkDAO parkDao;
	@Autowired
	private SurveyDAO surveyDao;
	@Autowired
	private WeatherDAO weatherDao;
	
	@RequestMapping(path={"/", "/home"}, method=RequestMethod.GET)
	public String showHomePage(HttpServletRequest request) {
		List<Park> parkList = parkDao.getAllParks();
		request.setAttribute("parks", parkList);
		return "home";
	}
	
	@RequestMapping(path={"/parkDetail"}, method=RequestMethod.GET)
	public String showParkInfoPage(HttpServletRequest request, @RequestParam String parkCode) {
		request.setAttribute("park", parkDao.getParkByParkCode(parkCode));
		request.setAttribute("weatherForecast", weatherDao.getWeatherByParkCode(parkCode));
		return "parkDetail";
	}
	
	@RequestMapping(path={"/weatherDetail"}, method=RequestMethod.GET)
	public String showWeatherDetailPage(HttpServletRequest request, @RequestParam String parkCode, @RequestParam int fiveDayForecastValue) {
		List<Weather> weatherForecast = weatherDao.getWeatherByParkCode(parkCode);
		request.setAttribute("weather", weatherForecast.get(fiveDayForecastValue - 1));
		request.setAttribute("park", parkDao.getParkByParkCode(parkCode));
		return "weatherDetail";
	}
	
	@RequestMapping(path={"/survey"}, method=RequestMethod.GET)
	public String showSurveyPage(HttpServletRequest request) {
		List<Park> parkList = parkDao.getAllParks();
		request.setAttribute("parks", parkList);
		return "survey";
	}
	
	@RequestMapping(path={"/survey"}, method=RequestMethod.POST)
	public String addSurveyToDB(Survey theSurvey, HttpServletRequest request) {
		if(theSurvey.getEmailAddress()=="" || !(theSurvey.getEmailAddress().contains("@")) || !(theSurvey.getEmailAddress().contains("."))){
			request.setAttribute("flag","false");
			request.setAttribute("email", theSurvey.getEmailAddress());
			request.setAttribute("parkCode",theSurvey.getParkCode());
			request.setAttribute("state",theSurvey.getState());
			request.setAttribute("activityLevel",theSurvey.getActivityLevel());

			List<Park> parkList = parkDao.getAllParks();
			request.setAttribute("parks", parkList);
			return "survey";
		}else{
		surveyDao.addSurvey(theSurvey);
		}
		return "redirect:/surveyDetail";
	}
	
	@RequestMapping(path={"/surveyDetail"}, method=RequestMethod.GET)
	public String showSurveyDetailPage(HttpServletRequest request) {
		Survey theSurvey = surveyDao.getTopSurveyPark();
		Park	 thePark = parkDao.getParkByParkCode(theSurvey.getParkCode());
		request.setAttribute("park", thePark);
		request.setAttribute("survey", theSurvey);
		return "surveyDetail";
	}
}