
package com.coronavirus.coronavirustracker.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "active",
    "confirmed",
    "deaths",
    "delta",
    "lastupdatedtime",
    "recovered",
    "state"
})
public class Statewise {

    @JsonProperty("active")
    private String active;
    @JsonProperty("confirmed")
    private String confirmed;
    @JsonProperty("deaths")
    private String deaths;
    @JsonProperty("delta")
    private Delta delta;
    @JsonProperty("lastupdatedtime")
    private String lastupdatedtime;
    @JsonProperty("recovered")
    private String recovered;
    @JsonProperty("state")
    private String state;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("active")
    public String getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(String active) {
        this.active = active;
    }

    @JsonProperty("confirmed")
    public String getConfirmed() {
        return confirmed;
    }

    @JsonProperty("confirmed")
    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    @JsonProperty("deaths")
    public String getDeaths() {
        return deaths;
    }

    @JsonProperty("deaths")
    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    @JsonProperty("delta")
    public Delta getDelta() {
        return delta;
    }

    @JsonProperty("delta")
    public void setDelta(Delta delta) {
        this.delta = delta;
    }

    @JsonProperty("lastupdatedtime")
    public String getLastupdatedtime() {
        return lastupdatedtime;
    }

    @JsonProperty("lastupdatedtime")
    public void setLastupdatedtime(String lastupdatedtime) {
        this.lastupdatedtime = lastupdatedtime;
    }

    @JsonProperty("recovered")
    public String getRecovered() {
        return recovered;
    }

    @JsonProperty("recovered")
    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
