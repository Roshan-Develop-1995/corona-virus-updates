package com.coronavirus.coronavirustracker.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coronavirus.coronavirustracker.model.Cases;
import com.coronavirus.coronavirustracker.model.ConfirmedCases;
import com.coronavirus.coronavirustracker.model.Corona;
import com.coronavirus.coronavirustracker.model.Deaths;
import com.coronavirus.coronavirustracker.model.Recovered;
import com.coronavirus.coronavirustracker.model.SuspectedCases;

@Service
public class CoronaVirusService {
	
	
	private static final String CASES_URL = "https://apigw.nubentos.com:443/t/nubentos.com/ncovapi/1.0.0/cases?country=Australia";
	private static final String CASES_SUSPECTED_URL = "https://apigw.nubentos.com:443/t/nubentos.com/ncovapi/1.0.0/cases/suspected?country=Australia";
	private static final String CASES_CONFIRMED_URL = "https://apigw.nubentos.com:443/t/nubentos.com/ncovapi/1.0.0/cases/confirmed?country=Australia";
	private static final String CASES_DEATH_URL = "https://apigw.nubentos.com:443/t/nubentos.com/ncovapi/1.0.0/deaths";
	private static final String CASES_RECOVERED_URL = "https://apigw.nubentos.com:443/t/nubentos.com/ncovapi/1.0.0/recovered?country=Australia";
	
	private String bearer = "0d0fe397-9619-3c79-92a6-619a08587764";
	
	@PostConstruct
	public Corona getDeaths() {
		HttpHeaders header=new HttpHeaders();
        header.add("Authorization","Bearer "+ bearer);
        HttpEntity<Cases> request=new HttpEntity(header);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<List<Cases>> responseCases = restTemplate.exchange(CASES_URL,HttpMethod.GET,request,new ParameterizedTypeReference<List<Cases>>() {
        });
        ResponseEntity<List<SuspectedCases>> responseSuspectedCases = restTemplate.exchange(CASES_SUSPECTED_URL ,HttpMethod.GET,request,new ParameterizedTypeReference<List<SuspectedCases>>() {
        });
        ResponseEntity<List<ConfirmedCases>> responseConfirmedCases = restTemplate.exchange(CASES_CONFIRMED_URL ,HttpMethod.GET,request,new ParameterizedTypeReference<List<ConfirmedCases>>() {
        });
        ResponseEntity<List<Deaths>> responseDeathCases = restTemplate.exchange(CASES_DEATH_URL,HttpMethod.GET,request,new ParameterizedTypeReference<List<Deaths>>() {
        });
        ResponseEntity<List<Recovered>> responseRecoveredCases = restTemplate.exchange(CASES_RECOVERED_URL ,HttpMethod.GET,request,new ParameterizedTypeReference<List<Recovered>>() {
        });
        List<Cases> cases = new ArrayList<Cases>();
        List<SuspectedCases> suspectedCases = new ArrayList<SuspectedCases>();
        List<ConfirmedCases> confirmedCases = new ArrayList<ConfirmedCases>();
        List<Deaths> deaths = new ArrayList<Deaths>();
        List<Recovered> recovered = new ArrayList<Recovered>();
        Corona corona = new Corona();
        cases = responseCases.getBody();
        suspectedCases = responseSuspectedCases.getBody();
        confirmedCases = responseConfirmedCases.getBody();
        deaths = responseDeathCases.getBody();
        recovered = responseRecoveredCases.getBody();
        for(Cases c:cases) {
        	corona.setNoOfCases(c.getCases());
        }
        for(SuspectedCases sc:suspectedCases) {
        	corona.setNoOfSuspectedCases(sc.getData());
        }
        for(ConfirmedCases cc:confirmedCases) {
        	corona.setNoOfConfirmedCases(cc.getData());
        }
        for(Deaths d:deaths) {
        	corona.setNoOfDeaths(d.getData());
        }
        for(Recovered r:recovered) {
        	corona.setNoOfRecoveredCases(r.getData());
        }
        
        return corona;
	}
	
	public Corona getCases(String country) {
		
		HttpHeaders header=new HttpHeaders();
        header.add("Authorization","Bearer "+ bearer);
        HttpEntity<Cases> request=new HttpEntity(header);
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<List<Cases>> responseCases = restTemplate.exchange(CASES_URL + country,HttpMethod.GET,request,new ParameterizedTypeReference<List<Cases>>() {
        });
        ResponseEntity<List<SuspectedCases>> responseSuspectedCases = restTemplate.exchange(CASES_SUSPECTED_URL + country,HttpMethod.GET,request,new ParameterizedTypeReference<List<SuspectedCases>>() {
        });
        ResponseEntity<List<ConfirmedCases>> responseConfirmedCases = restTemplate.exchange(CASES_CONFIRMED_URL + country,HttpMethod.GET,request,new ParameterizedTypeReference<List<ConfirmedCases>>() {
        });
        ResponseEntity<List<Deaths>> responseDeathCases = restTemplate.exchange(CASES_DEATH_URL,HttpMethod.GET,request,new ParameterizedTypeReference<List<Deaths>>() {
        });
        ResponseEntity<List<Recovered>> responseRecoveredCases = restTemplate.exchange(CASES_RECOVERED_URL + country,HttpMethod.GET,request,new ParameterizedTypeReference<List<Recovered>>() {
        });
        List<Cases> cases = new ArrayList<Cases>();
        List<SuspectedCases> suspectedCases = new ArrayList<SuspectedCases>();
        List<ConfirmedCases> confirmedCases = new ArrayList<ConfirmedCases>();
        List<Deaths> deaths = new ArrayList<Deaths>();
        List<Recovered> recovered = new ArrayList<Recovered>();
        Corona corona = new Corona();
        cases = responseCases.getBody();
        suspectedCases = responseSuspectedCases.getBody();
        confirmedCases = responseConfirmedCases.getBody();
        deaths = responseDeathCases.getBody();
        recovered = responseRecoveredCases.getBody();
        for(Cases c:cases) {
        	corona.setNoOfCases(c.getCases());
        }
        for(SuspectedCases sc:suspectedCases) {
        	corona.setNoOfSuspectedCases(sc.getData());
        }
        for(ConfirmedCases cc:confirmedCases) {
        	corona.setNoOfConfirmedCases(cc.getData());
        }
        for(Deaths d:deaths) {
        	corona.setNoOfDeaths(d.getData());
        }
        for(Recovered r:recovered) {
        	corona.setNoOfRecoveredCases(r.getData());
        }
        
        return corona;

	}
	
	

}
