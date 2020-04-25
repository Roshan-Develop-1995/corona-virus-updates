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

import com.coronavirus.coronavirustracker.model.Cases;
import com.coronavirus.coronavirustracker.model.CasesTimeSeries;
import com.coronavirus.coronavirustracker.model.ConfirmedCases;
import com.coronavirus.coronavirustracker.model.Corona;
import com.coronavirus.coronavirustracker.model.CoronaIndia;
import com.coronavirus.coronavirustracker.model.Deaths;
import com.coronavirus.coronavirustracker.model.Example;
import com.coronavirus.coronavirustracker.model.Recovered;
import com.coronavirus.coronavirustracker.model.Statewise;
import com.coronavirus.coronavirustracker.model.SuspectedCases;
import com.coronavirus.coronavirustracker.model.Tested;
import com.coronavirus.coronavirustracker.model.TestedData;

@Service
public class CoronaVirusService {
	
	
	private static final String CASES_URL = "https://apigw.nubentos.com:443/t/nubentos.com/ncovapi/1.0.0/cases?country=";
	private static final String CASES_SUSPECTED_URL = "https://apigw.nubentos.com:443/t/nubentos.com/ncovapi/1.0.0/cases/suspected?country=";
	private static final String CASES_CONFIRMED_URL = "https://apigw.nubentos.com:443/t/nubentos.com/ncovapi/1.0.0/cases/confirmed?country=";
	private static final String CASES_DEATH_URL = "https://apigw.nubentos.com:443/t/nubentos.com/ncovapi/1.0.0/deaths?country=";
	private static final String CASES_RECOVERED_URL = "https://apigw.nubentos.com:443/t/nubentos.com/ncovapi/1.0.0/recovered?country=";
	private static final String INDIA_CASES_URL = "https://api.covid19india.org/data.json";
	
	private String bearer = "42ec3654-8fb9-33af-ac59-420fef39d9ee";
	
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
		
		HttpHeaders header=new HttpHeaders();
        header.add("Authorization","Bearer "+ bearer);
        HttpEntity<Cases> request=new HttpEntity(header);
        RestTemplate restTemplate=new RestTemplate();
        try {
        	ResponseEntity<List<Cases>> responseCases = restTemplate.exchange(CASES_URL + country,HttpMethod.GET,request,new ParameterizedTypeReference<List<Cases>>() {
            });
            ResponseEntity<List<SuspectedCases>> responseSuspectedCases = restTemplate.exchange(CASES_SUSPECTED_URL + country,HttpMethod.GET,request,new ParameterizedTypeReference<List<SuspectedCases>>() {
            });
            ResponseEntity<List<ConfirmedCases>> responseConfirmedCases = restTemplate.exchange(CASES_CONFIRMED_URL + country,HttpMethod.GET,request,new ParameterizedTypeReference<List<ConfirmedCases>>() {
            });
            ResponseEntity<List<Deaths>> responseDeathCases = restTemplate.exchange(CASES_DEATH_URL + country,HttpMethod.GET,request,new ParameterizedTypeReference<List<Deaths>>() {
            });
            ResponseEntity<List<Recovered>> responseRecoveredCases = restTemplate.exchange(CASES_RECOVERED_URL + country,HttpMethod.GET,request,new ParameterizedTypeReference<List<Recovered>>() {
            });
            Corona corona = new Corona();
            if(HttpStatus.OK == responseCases.getStatusCode()) {
            	List<Cases> cases = new ArrayList<Cases>();
                List<SuspectedCases> suspectedCases = new ArrayList<SuspectedCases>();
                List<ConfirmedCases> confirmedCases = new ArrayList<ConfirmedCases>();
                List<Deaths> deaths = new ArrayList<Deaths>();
                List<Recovered> recovered = new ArrayList<Recovered>();
                cases = responseCases.getBody();
                suspectedCases = responseSuspectedCases.getBody();
                confirmedCases = responseConfirmedCases.getBody();
                deaths = responseDeathCases.getBody();
                recovered = responseRecoveredCases.getBody();
                
                corona.setLastUpdated(cases.get(0).getDate());
                corona.setCountry(cases.get(0).getCountry());
                corona.setNoOfCases(cases.get(0).getData());
                corona.setNoOfSuspectedCases(suspectedCases.get(0).getData());
                corona.setNoOfConfirmedCases(confirmedCases.get(0).getData());
                corona.setNoOfDeaths(deaths.get(0).getData());
                corona.setNoOfRecoveredCases(recovered.get(0).getData());
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
    		testedData.setPercentageOfIndividualTestedPerConfirmedCase(testedList.get(testedList.size()-1).getIndividualstestedperconfirmedcase());
    		testedData.setPercentageOfPositiveCase(testedList.get(testedList.size()-1).getTestpositivityrate());
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
