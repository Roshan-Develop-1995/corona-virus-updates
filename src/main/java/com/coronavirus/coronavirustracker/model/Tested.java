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
    "source",
    "totalindividualstested",
    "totalpositivecases",
    "totalsamplestested",
    "updatetimestamp"
})
public class Tested {

    @JsonProperty("source")
    private String source;
    @JsonProperty("totalindividualstested")
    private String totalindividualstested;
    @JsonProperty("totalpositivecases")
    private String totalpositivecases;
    @JsonProperty("totalsamplestested")
    private String totalsamplestested;
    @JsonProperty("updatetimestamp")
    private String updatetimestamp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("totalindividualstested")
    public String getTotalindividualstested() {
        return totalindividualstested;
    }

    @JsonProperty("totalindividualstested")
    public void setTotalindividualstested(String totalindividualstested) {
        this.totalindividualstested = totalindividualstested;
    }

    @JsonProperty("totalpositivecases")
    public String getTotalpositivecases() {
        return totalpositivecases;
    }

    @JsonProperty("totalpositivecases")
    public void setTotalpositivecases(String totalpositivecases) {
        this.totalpositivecases = totalpositivecases;
    }

    @JsonProperty("totalsamplestested")
    public String getTotalsamplestested() {
        return totalsamplestested;
    }

    @JsonProperty("totalsamplestested")
    public void setTotalsamplestested(String totalsamplestested) {
        this.totalsamplestested = totalsamplestested;
    }

    @JsonProperty("updatetimestamp")
    public String getUpdatetimestamp() {
        return updatetimestamp;
    }

    @JsonProperty("updatetimestamp")
    public void setUpdatetimestamp(String updatetimestamp) {
        this.updatetimestamp = updatetimestamp;
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
