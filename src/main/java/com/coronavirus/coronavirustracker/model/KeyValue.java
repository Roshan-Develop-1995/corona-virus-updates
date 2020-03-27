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
    "confirmeddelta",
    "counterforautotimeupdate",
    "deceaseddelta",
    "lastupdatedtime",
    "recovereddelta",
    "statesdelta"
})
public class KeyValue {

    @JsonProperty("confirmeddelta")
    private String confirmeddelta;
    @JsonProperty("counterforautotimeupdate")
    private String counterforautotimeupdate;
    @JsonProperty("deceaseddelta")
    private String deceaseddelta;
    @JsonProperty("lastupdatedtime")
    private String lastupdatedtime;
    @JsonProperty("recovereddelta")
    private String recovereddelta;
    @JsonProperty("statesdelta")
    private String statesdelta;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("confirmeddelta")
    public String getConfirmeddelta() {
        return confirmeddelta;
    }

    @JsonProperty("confirmeddelta")
    public void setConfirmeddelta(String confirmeddelta) {
        this.confirmeddelta = confirmeddelta;
    }

    @JsonProperty("counterforautotimeupdate")
    public String getCounterforautotimeupdate() {
        return counterforautotimeupdate;
    }

    @JsonProperty("counterforautotimeupdate")
    public void setCounterforautotimeupdate(String counterforautotimeupdate) {
        this.counterforautotimeupdate = counterforautotimeupdate;
    }

    @JsonProperty("deceaseddelta")
    public String getDeceaseddelta() {
        return deceaseddelta;
    }

    @JsonProperty("deceaseddelta")
    public void setDeceaseddelta(String deceaseddelta) {
        this.deceaseddelta = deceaseddelta;
    }

    @JsonProperty("lastupdatedtime")
    public String getLastupdatedtime() {
        return lastupdatedtime;
    }

    @JsonProperty("lastupdatedtime")
    public void setLastupdatedtime(String lastupdatedtime) {
        this.lastupdatedtime = lastupdatedtime;
    }

    @JsonProperty("recovereddelta")
    public String getRecovereddelta() {
        return recovereddelta;
    }

    @JsonProperty("recovereddelta")
    public void setRecovereddelta(String recovereddelta) {
        this.recovereddelta = recovereddelta;
    }

    @JsonProperty("statesdelta")
    public String getStatesdelta() {
        return statesdelta;
    }

    @JsonProperty("statesdelta")
    public void setStatesdelta(String statesdelta) {
        this.statesdelta = statesdelta;
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
