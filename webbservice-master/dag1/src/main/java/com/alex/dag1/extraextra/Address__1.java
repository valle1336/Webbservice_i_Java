package com.alex.dag1.extraextra;

import com.alex.dag1.extraextraextra.Coordinates__1;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Address__1 {

    @JsonProperty("address")
    private String address;
    @JsonProperty("city")
    private String city;
    @JsonProperty("coordinates")
    private Coordinates__1 coordinates;
    @JsonProperty("postalCode")
    private String postalCode;
    @JsonProperty("state")
    private String state;

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("coordinates")
    public Coordinates__1 getCoordinates() {
        return coordinates;
    }

    @JsonProperty("coordinates")
    public void setCoordinates(Coordinates__1 coordinates) {
        this.coordinates = coordinates;
    }

    @JsonProperty("postalCode")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty("postalCode")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

}
