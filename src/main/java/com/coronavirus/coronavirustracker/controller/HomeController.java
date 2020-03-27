package com.coronavirus.coronavirustracker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coronavirus.coronavirustracker.model.Corona;
import com.coronavirus.coronavirustracker.model.CoronaIndia;
import com.coronavirus.coronavirustracker.service.CoronaVirusService;

@Controller
public class HomeController {
	
	@Autowired
	CoronaVirusService coronaVirusService;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("flag","false");
		return "homeView";
	}
	
	@GetMapping("/searchIndianState.htm")
	public String showIndianCases(Model model) {
		List<CoronaIndia> indianCases = new ArrayList<CoronaIndia>();
		indianCases = coronaVirusService.getCasesInIndia();
		//indianCases.sort((o1,o2)->(o1.getActive()).compareTo(o2.getActive()));
		model.addAttribute("indianCases", indianCases);
		model.addAttribute("flag", "indianCases");
		return "homeView";
	}
	
	@GetMapping("/search.htm")
	public String showCases(@RequestParam("country") String country, Model model) {
		if(country == "") {
			model.addAttribute("search", "Please Specify a Country");
			model.addAttribute("flag", "noCountry");
		}
		else if(country != "") {
			Corona corona = coronaVirusService.getCases(country);
			if(null!=corona.getErrorMessage() && corona.getErrorMessage()!="") {
				model.addAttribute("flag", "noCountry");
				model.addAttribute("search", corona.getErrorMessage());
			}
			else {
				model.addAttribute("lastUpdated", corona.getLastUpdated());
				model.addAttribute("cases", corona.getNoOfCases());
				model.addAttribute("country", corona.getCountry());
				model.addAttribute("confirmedCases", corona.getNoOfConfirmedCases());
				model.addAttribute("suspectedCases", corona.getNoOfSuspectedCases());
				model.addAttribute("deaths", corona.getNoOfDeaths());
				model.addAttribute("recovered", corona.getNoOfRecoveredCases());
				model.addAttribute("flag","true");
			}
		}
		return "homeView";
	}

}
