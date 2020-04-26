package com.coronavirus.coronavirustracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coronavirus.coronavirustracker.model.CasesTimeSeries;
import com.coronavirus.coronavirustracker.model.Corona;
import com.coronavirus.coronavirustracker.model.CoronaIndia;
import com.coronavirus.coronavirustracker.model.Country;
import com.coronavirus.coronavirustracker.model.Example;
import com.coronavirus.coronavirustracker.model.Statewise;
import com.coronavirus.coronavirustracker.model.Summary;
import com.coronavirus.coronavirustracker.model.Tested;
import com.coronavirus.coronavirustracker.model.TestedData;

@Service
public class CoronaVirusService {
	
	
	private static final String COUNTRY_CASES_URL = "https://api.covid19api.com/summary";
	private static final String INDIA_CASES_URL = "https://api.covid19india.org/data.json";
	
	public List<CoronaIndia> getCasesInIndia() {
		List <CoronaIndia> coronaIndiaCases = new ArrayList<>();
		HttpHeaders header=new HttpHeaders();
        HttpEntity<Example> request=new HttpEntity(header);
        RestTemplate restTemplate=new RestTemplate();
        try {
        	ResponseEntity<Example> responseStateWise = restTemplate.exchange(INDIA_CASES_URL, HttpMethod.GET, request, new ParameterizedTypeReference<Example>() {
			});
    		List<Statewise> stateWiseResponses = new ArrayList<>();
    		Example exampleResponse = new  Example();
    		exampleResponse = responseStateWise.getBody();
    		stateWiseResponses = exampleResponse.getStatewise();
    		for(Statewise sw: stateWiseResponses) {
    			
    			CoronaIndia coronaIndia = new CoronaIndia();
    			coronaIndia.setState(sw.getState());
    			coronaIndia.setActive(sw.getActive());
    			coronaIndia.setConfirmed(sw.getConfirmed());
    			coronaIndia.setDeaths(sw.getDeaths());
    			coronaIndia.setLastUpdatedTime(sw.getLastupdatedtime());
    			coronaIndia.setRecovered(sw.getRecovered());
    			coronaIndiaCases.add(coronaIndia);
    		}
    		
        	
    		return coronaIndiaCases;
        	
        }catch(Exception e) {
        	CoronaIndia coronaIndia = new CoronaIndia();
        	coronaIndia.setErrorMeassage("Some Error Occured. Please try after sometime.");
        	coronaIndiaCases.add(coronaIndia);
        	return coronaIndiaCases;
        }

	}
	
	public CoronaIndia getCasesTimeSeries() {
		HttpHeaders header=new HttpHeaders();
        HttpEntity<Example> request=new HttpEntity(header);
        RestTemplate restTemplate=new RestTemplate();
        try {
        	ResponseEntity<Example> responseStateWise = restTemplate.exchange(INDIA_CASES_URL, HttpMethod.GET, request, new ParameterizedTypeReference<Example>() {
			});
        	CasesTimeSeries cts = new CasesTimeSeries();
        	Example exampleResponse = new  Example();
    		exampleResponse = responseStateWise.getBody();
    		cts = exampleResponse.getCasesTimeSeries().get(exampleResponse.getCasesTimeSeries().size()-1);
    		CoronaIndia coronaIndia = new CoronaIndia();
    		coronaIndia.setPreviousConfirmed(cts.getDailyconfirmed());
    		coronaIndia.setPreviousDay(cts.getDate());
    		coronaIndia.setPreviousDeaths(cts.getDailydeceased());
    		coronaIndia.setPreviousRecovered(cts.getDailyrecovered());
    		return coronaIndia;
        }catch(Exception e) {
        	CoronaIndia coronaIndia = new CoronaIndia();
        	coronaIndia.setErrorMeassage("Some Error Occured. Please try after sometime.");
        	return coronaIndia;
        }
	}
	
	public Corona getCases(String country) {
		
		List <Country> countryList = new ArrayList<>();
		HttpHeaders header=new HttpHeaders();
        HttpEntity<Summary> request=new HttpEntity(header);
        RestTemplate restTemplate=new RestTemplate();
        try {
        	ResponseEntity<Summary> responseSummary = restTemplate.exchange(COUNTRY_CASES_URL, HttpMethod.GET, request, new ParameterizedTypeReference<Summary>() {
			});
        	Corona corona = new Corona();
            if(HttpStatus.OK == responseSummary.getStatusCode()) {
            	Summary summary = responseSummary.getBody();
            	countryList = summary.getCountries();
            	for(Country c : countryList) {
            		if(country.equals(c.getCountry()) || country.equals(c.getCountryCode()) || country.equals(c.getSlug())) {
            			corona.setCountry(c.getCountry());
                    	corona.setNoOfCases(c.getTotalConfirmed());
                        corona.setNoOfConfirmedCases(c.getNewConfirmed());
                        corona.setNoOfDeaths(c.getTotalDeaths());
                        corona.setNoOfRecoveredCases(c.getTotalRecovered());
                        corona.setLastUpdated(c.getDate());
            		}
            	}
            	if(corona.getCountry().equals("") || corona.getCountry()==null)
            		corona.setErrorMessage("No data found for this country, please modify your search or provide a country code.");
            }
            else
            	corona.setErrorMessage("No data found for this country, please provide a valid country.");
            return corona;
        }catch(Exception e) {
        	Corona corona = new Corona();
        	corona.setErrorMessage("No data found for this country, please provide a valid country.");
        	return corona;
        }
        

	}
	
	public TestedData getTestData() {
		HttpHeaders header=new HttpHeaders();
        HttpEntity<Example> request=new HttpEntity(header);
        RestTemplate restTemplate=new RestTemplate();
        try {
        	ResponseEntity<Example> example = restTemplate.exchange(INDIA_CASES_URL, HttpMethod.GET, request, new ParameterizedTypeReference<Example>() {
			});
        	List<Tested> testedList = new ArrayList<>();
    		Example exampleResponse = new  Example();
    		exampleResponse = example.getBody();
    		testedList = exampleResponse.getTested();
    		TestedData testedData = new TestedData();
    		testedData.setPercentageOfIndividualTestedPerConfirmedCase(testedList.get(testedList.size()-2).getIndividualstestedperconfirmedcase());
    		testedData.setPercentageOfPositiveCase(testedList.get(testedList.size()-2).getTestpositivityrate());
    		testedData.setTotalTests(testedList.get(testedList.size()-1).getTotalsamplestested());
    		testedData.setLastUpdated(testedList.get(testedList.size()-1).getUpdatetimestamp());
    		return testedData;
        }catch(Exception e) {
        	TestedData testedData = new TestedData();
        	testedData.setErrorMessage("Some Error Occurred, Try Later.");
        	return testedData;
        }
	}
	
	

}
