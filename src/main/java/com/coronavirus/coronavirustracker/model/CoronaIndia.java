package com.coronavirus.coronavirustracker.model;

public class CoronaIndia {
	
	private String active;
	private String confirmed;
	private String deaths;
	private String lastUpdatedTime;
	private String recovered;
	private String state;
	private String previousConfirmed;
	private String previousDeaths;
	private String previousRecovered;
	private String previousDay;
	private String errorMeassage;
	
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}
	public String getDeaths() {
		return deaths;
	}
	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}
	public String getLastUpdatedTime() {
		return lastUpdatedTime;
	}
	public void setLastUpdatedTime(String lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
	public String getRecovered() {
		return recovered;
	}
	public void setRecovered(String recovered) {
		this.recovered = recovered;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPreviousConfirmed() {
		return previousConfirmed;
	}
	public void setPreviousConfirmed(String previousConfirmed) {
		this.previousConfirmed = previousConfirmed;
	}
	public String getPreviousDeaths() {
		return previousDeaths;
	}
	public void setPreviousDeaths(String previousDeaths) {
		this.previousDeaths = previousDeaths;
	}
	
	public String getPreviousRecovered() {
		return previousRecovered;
	}
	public void setPreviousRecovered(String previousRecovered) {
		this.previousRecovered = previousRecovered;
	}
	public String getPreviousDay() {
		return previousDay;
	}
	public void setPreviousDay(String previousDay) {
		this.previousDay = previousDay;
	}
	public String getErrorMeassage() {
		return errorMeassage;
	}
	public void setErrorMeassage(String errorMeassage) {
		this.errorMeassage = errorMeassage;
	}
		

}
