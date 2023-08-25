package com.alex.dag1.extras;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hair {

    @JsonProperty("color")
    private String color;
    @JsonProperty("type")
    private String type;

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

}
