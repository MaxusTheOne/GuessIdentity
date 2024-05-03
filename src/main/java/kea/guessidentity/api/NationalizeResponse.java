package kea.guessidentity.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class NationalizeResponse {

    @JsonProperty("country")
    private List<Country> country;
    @JsonProperty("name")
    private String name;
    @JsonProperty("count")
    private Integer count;

    public NationalizeResponse() {
    }

    public List<Country> getCountry() {
        if (this.country == null) {
            return null; // or return null if you prefer
        } else {
            return this.country;
        }
    }
    public void setCountry(List<Country> country) {
        this.country = country;
    }

    public Double getProbability() {
        if (this.country == null) {
            return 0.0;
        } else {
            return this.country.get(0).getProbability();
        }
    }

    public void setProbability(Double probability) {
        this.country.get(0).setProbability(probability);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
