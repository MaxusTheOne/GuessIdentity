package kea.guessidentity.api;

import com.fasterxml.jackson.annotation.JsonProperty;

class Country {
    @JsonProperty("country_id")
    private String country_id;
    @JsonProperty("probability")
    private Double probability;

    public Country() {
    }
    // Getters and setters
    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }
}