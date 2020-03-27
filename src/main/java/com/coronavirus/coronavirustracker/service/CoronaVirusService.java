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
import com.coronavirus.coronavirustracker.model.ConfirmedCases;
import com.coronavirus.coronavirustracker.model.Corona;
import com.coronavirus.coronavirustracker.model.CoronaIndia;
import com.coronavirus.coronavirustracker.model.Deaths;
import com.coronavirus.coronavirustracker.model.Recovered;
import com.coronavirus.coronavirustracker.model.SuspectedCases;

@Service
public class CoronaVirusService {
	
	
	private static final String CASES_URL = "https://apigw.nubentos.com:443/t/nubentos.com/ncovapi/1.0.0/cases?country=";
	private static final String CASES_SUSPECTED_URL = "https://apigw.nubentos.com:443/t/nubentos.com/ncovapi/1.0.0/cases/suspected?country=";
	private static final String CASES_CONFIRMED_URL = "https://apigw.nubentos.com:443/t/nubentos.com/ncovapi/1.0.0/cases/confirmed?country=";
	private static final String CASES_DEATH_URL = "https://apigw.nubentos.com:443/t/nubentos.com/ncovapi/1.0.0/deaths?country=";
	private static final String CASES_RECOVERED_URL = "https://apigw.nubentos.com:443/t/nubentos.com/ncovapi/1.0.0/recovered?country=";
	
	private String bearer = "42ec3654-8fb9-33af-ac59-420fef39d9ee";
	
	/*@PostConstruct
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
        /*for(Cases c:cases) {
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
        
        corona.setNoOfCases(cases.get(0).getCases());
        corona.setNoOfSuspectedCases(suspectedCases.get(0).getData());
        corona.setNoOfConfirmedCases(confirmedCases.get(0).getData());
        corona.setNoOfDeaths(deaths.get(0).getData());
        corona.setNoOfRecoveredCases(recovered.get(0).getData());
        
        return corona;
	}*/
	
	public List<CoronaIndia> getCasesInIndia() {
		List <CoronaIndia> coronaIndiaCases = new ArrayList<>();
		CoronaIndia coronaIndia = new CoronaIndia();
		coronaIndia.setState("Kerela");
		coronaIndia.setPositiveCases(176);
		coronaIndia.setNoOfForeigners(7);
		coronaIndia.setNoOfIndians(coronaIndia.getPositiveCases()-coronaIndia.getNoOfForeigners());
		coronaIndia.setDeaths(0);
		coronaIndiaCases.add(coronaIndia);
		
		CoronaIndia coronaIndia1 = new CoronaIndia();
		coronaIndia1.setState("Punjab");
		coronaIndia1.setPositiveCases(29);
		coronaIndia1.setNoOfForeigners(0);
		coronaIndia1.setNoOfIndians(coronaIndia1.getPositiveCases()-coronaIndia1.getNoOfForeigners());
		coronaIndia1.setDeaths(1);
		coronaIndiaCases.add(coronaIndia1);
		
		CoronaIndia coronaIndia2 = new CoronaIndia();
		coronaIndia2.setState("Delhi");
		coronaIndia2.setPositiveCases(39);
		coronaIndia2.setNoOfForeigners(1);
		coronaIndia2.setNoOfIndians(coronaIndia2.getPositiveCases()-coronaIndia2.getNoOfForeigners());
		coronaIndia2.setDeaths(1);
		coronaIndiaCases.add(coronaIndia2);
		
		CoronaIndia coronaIndia3 = new CoronaIndia();
		coronaIndia3.setState("Jammu and Kashmir");
		coronaIndia3.setPositiveCases(18);
		coronaIndia3.setNoOfForeigners(0);
		coronaIndia3.setNoOfIndians(coronaIndia3.getPositiveCases()-coronaIndia3.getNoOfForeigners());
		coronaIndia3.setDeaths(1);
		coronaIndiaCases.add(coronaIndia3);
		
		CoronaIndia coronaIndia4 = new CoronaIndia();
		coronaIndia4.setState("Ladakh");
		coronaIndia4.setPositiveCases(13);
		coronaIndia4.setNoOfForeigners(0);
		coronaIndia4.setNoOfIndians(coronaIndia4.getPositiveCases()-coronaIndia4.getNoOfForeigners());
		coronaIndia4.setDeaths(0);
		coronaIndiaCases.add(coronaIndia4);
		
		CoronaIndia coronaIndia5 = new CoronaIndia();
		coronaIndia5.setState("Rajasthan");
		coronaIndia5.setPositiveCases(43);
		coronaIndia5.setNoOfForeigners(2);
		coronaIndia5.setNoOfIndians(coronaIndia5.getPositiveCases()-coronaIndia5.getNoOfForeigners());
		coronaIndia5.setDeaths(0);
		coronaIndiaCases.add(coronaIndia5);
		
		CoronaIndia coronaIndia6 = new CoronaIndia();
		coronaIndia6.setState("Uttar Pradesh");
		coronaIndia6.setPositiveCases(43);
		coronaIndia6.setNoOfForeigners(1);
		coronaIndia6.setNoOfIndians(coronaIndia6.getPositiveCases()-coronaIndia6.getNoOfForeigners());
		coronaIndia6.setDeaths(0);
		coronaIndiaCases.add(coronaIndia6);
		
		CoronaIndia coronaIndia7 = new CoronaIndia();
		coronaIndia7.setState("Karnataka");
		coronaIndia7.setPositiveCases(62);
		coronaIndia7.setNoOfForeigners(0);
		coronaIndia7.setNoOfIndians(coronaIndia7.getPositiveCases()-coronaIndia7.getNoOfForeigners());
		coronaIndia7.setDeaths(3);
		coronaIndiaCases.add(coronaIndia7);
		
		CoronaIndia coronaIndia8 = new CoronaIndia();
		coronaIndia8.setState("Tamil Nadu");
		coronaIndia8.setPositiveCases(35);
		coronaIndia8.setNoOfForeigners(3);
		coronaIndia8.setNoOfIndians(coronaIndia8.getPositiveCases()-coronaIndia8.getNoOfForeigners());
		coronaIndia8.setDeaths(1);
		coronaIndiaCases.add(coronaIndia8);
		
		CoronaIndia coronaIndia9 = new CoronaIndia();
		coronaIndia9.setState("Telangana");
		coronaIndia9.setPositiveCases(59);
		coronaIndia9.setNoOfForeigners(11);
		coronaIndia9.setNoOfIndians(coronaIndia9.getPositiveCases()-coronaIndia9.getNoOfForeigners());
		coronaIndia9.setDeaths(0);
		coronaIndiaCases.add(coronaIndia9);
		
		/*CoronaIndia coronaIndia10 = new CoronaIndia();
		coronaIndia10.setState("Telangana");
		coronaIndia10.setPositiveCases(43);
		coronaIndia10.setNoOfForeigners(11);
		coronaIndia10.setNoOfIndians(coronaIndia10.getPositiveCases()-coronaIndia10.getNoOfForeigners());
		coronaIndia10.setDeaths(0);
		coronaIndiaCases.add(coronaIndia10);*/
		
		CoronaIndia coronaIndia11 = new CoronaIndia();
		coronaIndia11.setState("Haryana");
		coronaIndia11.setPositiveCases(21);
		coronaIndia11.setNoOfForeigners(14);
		coronaIndia11.setNoOfIndians(coronaIndia11.getPositiveCases()-coronaIndia11.getNoOfForeigners());
		coronaIndia11.setDeaths(0);
		coronaIndiaCases.add(coronaIndia11);
		
		/*CoronaIndia coronaIndia12 = new CoronaIndia();
		coronaIndia12.setState("Haryana");
		coronaIndia12.setPositiveCases(21);
		coronaIndia12.setNoOfForeigners(14);
		coronaIndia12.setNoOfIndians(coronaIndia12.getPositiveCases()-coronaIndia12.getNoOfForeigners());
		coronaIndia12.setDeaths(0);
		coronaIndiaCases.add(coronaIndia12);*/
		
		CoronaIndia coronaIndia13 = new CoronaIndia();
		coronaIndia13.setState("Andhra Pradesh");
		coronaIndia13.setPositiveCases(12);
		coronaIndia13.setNoOfForeigners(0);
		coronaIndia13.setNoOfIndians(coronaIndia13.getPositiveCases()-coronaIndia13.getNoOfForeigners());
		coronaIndia13.setDeaths(0);
		coronaIndiaCases.add(coronaIndia13);
		
		CoronaIndia coronaIndia14 = new CoronaIndia();
		coronaIndia14.setState("Maharashtra");
		coronaIndia14.setPositiveCases(157);
		coronaIndia14.setNoOfForeigners(3);
		coronaIndia14.setNoOfIndians(coronaIndia14.getPositiveCases()-coronaIndia14.getNoOfForeigners());
		coronaIndia14.setDeaths(5);
		coronaIndiaCases.add(coronaIndia14);
		
		CoronaIndia coronaIndia15 = new CoronaIndia();
		coronaIndia15.setState("Himachal Pradesh");
		coronaIndia15.setPositiveCases(4);
		coronaIndia15.setNoOfForeigners(0);
		coronaIndia15.setNoOfIndians(coronaIndia15.getPositiveCases()-coronaIndia15.getNoOfForeigners());
		coronaIndia15.setDeaths(1);
		coronaIndiaCases.add(coronaIndia15);
		
		CoronaIndia coronaIndia16 = new CoronaIndia();
		coronaIndia16.setState("Gujarat");
		coronaIndia16.setPositiveCases(43);
		coronaIndia16.setNoOfForeigners(0);
		coronaIndia16.setNoOfIndians(coronaIndia16.getPositiveCases()-coronaIndia16.getNoOfForeigners());
		coronaIndia16.setDeaths(3);
		coronaIndiaCases.add(coronaIndia16);
		
		CoronaIndia coronaIndia17 = new CoronaIndia();
		coronaIndia17.setState("Uttarakhand");
		coronaIndia17.setPositiveCases(4);
		coronaIndia17.setNoOfForeigners(0);
		coronaIndia17.setNoOfIndians(coronaIndia17.getPositiveCases()-coronaIndia17.getNoOfForeigners());
		coronaIndia17.setDeaths(0);
		coronaIndiaCases.add(coronaIndia17);
		
		CoronaIndia coronaIndia18 = new CoronaIndia();
		coronaIndia18.setState("Odisha");
		coronaIndia18.setPositiveCases(3);
		coronaIndia18.setNoOfForeigners(0);
		coronaIndia18.setNoOfIndians(coronaIndia18.getPositiveCases()-coronaIndia18.getNoOfForeigners());
		coronaIndia18.setDeaths(0);
		coronaIndiaCases.add(coronaIndia18);
		
		CoronaIndia coronaIndia19 = new CoronaIndia();
		coronaIndia19.setState("West Bengal");
		coronaIndia19.setPositiveCases(11);
		coronaIndia19.setNoOfForeigners(0);
		coronaIndia19.setNoOfIndians(coronaIndia19.getPositiveCases()-coronaIndia19.getNoOfForeigners());
		coronaIndia19.setDeaths(1);
		coronaIndiaCases.add(coronaIndia19);
		
		CoronaIndia coronaIndia20 = new CoronaIndia();
		coronaIndia20.setState("Chandigarh");
		coronaIndia20.setPositiveCases(7);
		coronaIndia20.setNoOfForeigners(0);
		coronaIndia20.setNoOfIndians(coronaIndia20.getPositiveCases()-coronaIndia20.getNoOfForeigners());
		coronaIndia20.setDeaths(0);
		coronaIndiaCases.add(coronaIndia20);
		
		CoronaIndia coronaIndia21 = new CoronaIndia();
		coronaIndia21.setState("Chhattisgarh");
		coronaIndia21.setPositiveCases(6);
		coronaIndia21.setNoOfForeigners(0);
		coronaIndia21.setNoOfIndians(coronaIndia21.getPositiveCases()-coronaIndia21.getNoOfForeigners());
		coronaIndia21.setDeaths(0);
		coronaIndiaCases.add(coronaIndia21);
		
		CoronaIndia coronaIndia22 = new CoronaIndia();
		coronaIndia22.setState("Madhya Pradesh");
		coronaIndia22.setPositiveCases(24);
		coronaIndia22.setNoOfForeigners(0);
		coronaIndia22.setNoOfIndians(coronaIndia22.getPositiveCases()-coronaIndia22.getNoOfForeigners());
		coronaIndia22.setDeaths(2);
		coronaIndiaCases.add(coronaIndia22);
		
		CoronaIndia coronaIndia23 = new CoronaIndia();
		coronaIndia23.setState("Bihar");
		coronaIndia23.setPositiveCases(7);
		coronaIndia23.setNoOfForeigners(0);
		coronaIndia23.setNoOfIndians(coronaIndia23.getPositiveCases()-coronaIndia23.getNoOfForeigners());
		coronaIndia23.setDeaths(1);
		coronaIndiaCases.add(coronaIndia23);
		
		CoronaIndia coronaIndia24 = new CoronaIndia();
		coronaIndia24.setState("Puducherry");
		coronaIndia24.setPositiveCases(1);
		coronaIndia24.setNoOfForeigners(0);
		coronaIndia24.setNoOfIndians(coronaIndia24.getPositiveCases()-coronaIndia24.getNoOfForeigners());
		coronaIndia24.setDeaths(0);
		coronaIndiaCases.add(coronaIndia24);
		
		CoronaIndia coronaIndia25 = new CoronaIndia();
		coronaIndia25.setState("Manipur");
		coronaIndia25.setPositiveCases(1);
		coronaIndia25.setNoOfForeigners(0);
		coronaIndia25.setNoOfIndians(coronaIndia25.getPositiveCases()-coronaIndia25.getNoOfForeigners());
		coronaIndia25.setDeaths(0);
		coronaIndiaCases.add(coronaIndia25);
		
		CoronaIndia coronaIndia26 = new CoronaIndia();
		coronaIndia26.setState("Mizoram");
		coronaIndia26.setPositiveCases(1);
		coronaIndia26.setNoOfForeigners(0);
		coronaIndia26.setNoOfIndians(coronaIndia26.getPositiveCases()-coronaIndia26.getNoOfForeigners());
		coronaIndia26.setDeaths(0);
		coronaIndiaCases.add(coronaIndia26);
		
		CoronaIndia coronaIndia27 = new CoronaIndia();
		coronaIndia27.setState("Goa");
		coronaIndia27.setPositiveCases(6);
		coronaIndia27.setNoOfForeigners(0);
		coronaIndia27.setNoOfIndians(coronaIndia27.getPositiveCases()-coronaIndia27.getNoOfForeigners());
		coronaIndia27.setDeaths(0);
		coronaIndiaCases.add(coronaIndia27);
		
		CoronaIndia coronaIndia28 = new CoronaIndia();
		coronaIndia28.setState("Andaman and Nicobar Islands");
		coronaIndia28.setPositiveCases(1);
		coronaIndia28.setNoOfForeigners(0);
		coronaIndia28.setNoOfIndians(coronaIndia28.getPositiveCases()-coronaIndia28.getNoOfForeigners());
		coronaIndia28.setDeaths(0);
		coronaIndiaCases.add(coronaIndia28);
		
		return coronaIndiaCases;
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
	
	

}
