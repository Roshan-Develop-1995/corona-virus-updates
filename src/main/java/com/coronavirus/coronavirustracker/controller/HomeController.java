package com.coronavirus.coronavirustracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coronavirus.coronavirustracker.model.Corona;
import com.coronavirus.coronavirustracker.service.CoronaVirusService;

@Controller
public class HomeController {
	
	@Autowired
	CoronaVirusService coronaVirusService;
	
	@GetMapping("/")
	public String home(Model model) {
		Corona corona = coronaVirusService.getDeaths();
		model.addAttribute("cases", corona.getNoOfCases());
		model.addAttribute("confirmedCases", corona.getNoOfConfirmedCases());
		model.addAttribute("suspectedCases", corona.getNoOfSuspectedCases());
		model.addAttribute("deaths", corona.getNoOfDeaths());
		model.addAttribute("recovered", corona.getNoOfRecoveredCases());
		model.addAttribute("flag","true");
		return "homeView";
	}
	
	@GetMapping("/search.htm")
	public String showCases(@RequestParam("country") String country, Model model) {
		Corona corona = coronaVirusService.getCases(country);
		model.addAttribute("cases", corona.getNoOfCases());
		model.addAttribute("confirmedCases", corona.getNoOfConfirmedCases());
		model.addAttribute("suspectedCases", corona.getNoOfSuspectedCases());
		model.addAttribute("deaths", corona.getNoOfDeaths());
		model.addAttribute("recovered", corona.getNoOfRecoveredCases());
		model.addAttribute("flag","true");
		return "homeView";
	}

}
