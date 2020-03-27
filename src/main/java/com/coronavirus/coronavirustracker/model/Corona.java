package com.coronavirus.coronavirustracker.model;

public class Corona {
	
	private int noOfCases;
	private String lastUpdated;
	private int noOfSuspectedCases;
	private int noOfConfirmedCases;
	private int noOfDeaths;
	private int noOfRecoveredCases;
	private String country;
	private String errorMessage;

	public int getNoOfCases() {
		return noOfCases;
	}

	public void setNoOfCases(int noOfCases) {
		this.noOfCases = noOfCases;
	}

	public int getNoOfSuspectedCases() {
		return noOfSuspectedCases;
	}

	public void setNoOfSuspectedCases(int noOfSuspectedCases) {
		this.noOfSuspectedCases = noOfSuspectedCases;
	}

	public int getNoOfConfirmedCases() {
		return noOfConfirmedCases;
	}

	public void setNoOfConfirmedCases(int noOfConfirmedCases) {
		this.noOfConfirmedCases = noOfConfirmedCases;
	}

	public int getNoOfDeaths() {
		return noOfDeaths;
	}

	public void setNoOfDeaths(int noOfDeaths) {
		this.noOfDeaths = noOfDeaths;
	}

	public int getNoOfRecoveredCases() {
		return noOfRecoveredCases;
	}

	public void setNoOfRecoveredCases(int noOfRecoveredCases) {
		this.noOfRecoveredCases = noOfRecoveredCases;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
}
