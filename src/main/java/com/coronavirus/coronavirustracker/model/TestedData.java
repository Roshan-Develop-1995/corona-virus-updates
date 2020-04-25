package com.coronavirus.coronavirustracker.model;

public class TestedData {
	
	private String percentageOfIndividualTestedPerConfirmedCase;
	private String percentageOfPositiveCase;
	private String totalTests;
	private String lastUpdated;
	private String errorMessage;
	public String getPercentageOfIndividualTestedPerConfirmedCase() {
		return percentageOfIndividualTestedPerConfirmedCase;
	}
	public void setPercentageOfIndividualTestedPerConfirmedCase(String percentageOfIndividualTestedPerConfirmedCase) {
		this.percentageOfIndividualTestedPerConfirmedCase = percentageOfIndividualTestedPerConfirmedCase;
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
