package com.coronavirus.coronavirustracker.model;

public class TestedData {
	
	private String recoveryRate;
	private String deathRate;
	private String percentageOfPositiveCase;
	private String totalTests;
	private String lastUpdated;
	private String errorMessage;
	
	public String getRecoveryRate() {
		return recoveryRate;
	}
	public void setRecoveryRate(String recoveryRate) {
		this.recoveryRate = recoveryRate;
	}
	public String getDeathRate() {
		return deathRate;
	}
	public void setDeathRate(String deathRate) {
		this.deathRate = deathRate;
	}
	public String getPercentageOfPositiveCase() {
		return percentageOfPositiveCase;
	}
	public void setPercentageOfPositiveCase(String percentageOfPositiveCase) {
		this.percentageOfPositiveCase = percentageOfPositiveCase;
	}
	public String getTotalTests() {
		return totalTests;
	}
	public void setTotalTests(String totalTests) {
		this.totalTests = totalTests;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	

}
