package com.coronavirus.coronavirustracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GlobalData {
	
	private Integer newConfirmed;
    private Integer totalConfirmed;
    private Integer newDeaths;
    private Integer totalDeaths;
    private Integer newRecovered;
    private Integer totalRecovered;
    private String errorMessage;
	public Integer getNewConfirmed() {
		return newConfirmed;
	}
	public void setNewConfirmed(Integer newConfirmed) {
		this.newConfirmed = newConfirmed;
	}
	public Integer getTotalConfirmed() {
		return totalConfirmed;
	}
	public void setTotalConfirmed(Integer totalConfirmed) {
		this.totalConfirmed = totalConfirmed;
	}
	public Integer getNewDeaths() {
		return newDeaths;
	}
	public void setNewDeaths(Integer newDeaths) {
		this.newDeaths = newDeaths;
	}
	public Integer getTotalDeaths() {
		return totalDeaths;
	}
	public void setTotalDeaths(Integer totalDeaths) {
		this.totalDeaths = totalDeaths;
	}
	public Integer getNewRecovered() {
		return newRecovered;
	}
	public void setNewRecovered(Integer newRecovered) {
		this.newRecovered = newRecovered;
	}
	public Integer getTotalRecovered() {
		return totalRecovered;
	}
	public void setTotalRecovered(Integer totalRecovered) {
		this.totalRecovered = totalRecovered;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
    
    

}
