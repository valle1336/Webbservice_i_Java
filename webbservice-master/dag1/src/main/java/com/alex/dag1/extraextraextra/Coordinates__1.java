package com.alex.dag1.extraextraextra;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coordinates__1 {

    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("lng")
    private Double lng;

    @JsonProperty("lat")
    public Double getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(Double lat) {
        this.lat = lat;
    }

    @JsonProperty("lng")
    public Double getLng() {
        return lng;
    }

    @JsonProperty("lng")
    public void setLng(Double lng) {
        this.lng = lng;
    }

}
