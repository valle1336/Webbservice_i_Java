package com.alex.dag1.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DummyJson {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("discountPercentage")
    private Double discountPercentage;
    @JsonProperty("rating")
    private Double rating;
    @JsonProperty("stock")
    private Integer stock;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("category")
    private String category;
    @JsonProperty("thumbnail")
    private String thumbnail;
    @JsonProperty("images")
    private List<String> images;

}


