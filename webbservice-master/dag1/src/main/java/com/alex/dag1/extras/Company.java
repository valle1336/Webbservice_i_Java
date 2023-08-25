package com.alex.dag1.extras;

import com.alex.dag1.extraextra.Address__1;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Company {

    @JsonProperty("address")
    private Address__1 address;
    @JsonProperty("department")
    private String department;
    @JsonProperty("name")
    private String name;
    @JsonProperty("title")
    private String title;

    @JsonProperty("address")
    public Address__1 getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address__1 address) {
        this.address = address;
    }

    @JsonProperty("department")
    public String getDepartment() {
        return department;
    }

    @JsonProperty("department")
    public void setDepartment(String department) {
        this.department = department;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

}
