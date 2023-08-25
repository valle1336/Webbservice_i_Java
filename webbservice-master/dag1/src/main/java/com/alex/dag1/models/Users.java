package com.alex.dag1.models;

import com.alex.dag1.extras.Address;
import com.alex.dag1.extras.Bank;
import com.alex.dag1.extras.Company;
import com.alex.dag1.extras.Hair;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.apache.catalina.User;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;


public class Users {

@JsonProperty("id")
private Integer id;
@JsonProperty("firstName")
private String firstName;
@JsonProperty("lastName")
private String lastName;
@JsonProperty("maidenName")
private String maidenName;
@JsonProperty("age")
private Integer age;
@JsonProperty("gender")
private String gender;
@JsonProperty("email")
private String email;
@JsonProperty("phone")
private String phone;
@JsonProperty("username")
private String username;
@JsonProperty("password")
private String password;
@JsonProperty("birthDate")
private String birthDate;
@JsonProperty("image")
private String image;
@JsonProperty("bloodGroup")
private String bloodGroup;
@JsonProperty("height")
private Integer height;
@JsonProperty("weight")
private Double weight;
@JsonProperty("eyeColor")
private String eyeColor;
@JsonProperty("hair")
private Hair hair;
@JsonProperty("domain")
private String domain;
@JsonProperty("ip")
private String ip;
@JsonProperty("address")
private Address address;
@JsonProperty("macAddress")
private String macAddress;
@JsonProperty("university")
private String university;
@JsonProperty("bank")
private Bank bank;
@JsonProperty("company")
private Company company;
@JsonProperty("ein")
private String ein;
@JsonProperty("ssn")
private String ssn;
@JsonProperty("userAgent")
private String userAgent;

@JsonProperty("id")
public Integer getId() {
        return id;
        }

@JsonProperty("id")
public void setId(Integer id) {
        this.id = id;
        }

@JsonProperty("firstName")
public String getFirstName() {
        return firstName;
        }

@JsonProperty("firstName")
public void setFirstName(String firstName) {
        this.firstName = firstName;
        }

@JsonProperty("lastName")
public String getLastName() {
        return lastName;
        }

@JsonProperty("lastName")
public void setLastName(String lastName) {
        this.lastName = lastName;
        }

@JsonProperty("maidenName")
public String getMaidenName() {
        return maidenName;
        }

@JsonProperty("maidenName")
public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
        }

@JsonProperty("age")
public Integer getAge() {
        return age;
        }

@JsonProperty("age")
public void setAge(Integer age) {
        this.age = age;
        }

@JsonProperty("gender")
public String getGender() {
        return gender;
        }

@JsonProperty("gender")
public void setGender(String gender) {
        this.gender = gender;
        }

@JsonProperty("email")
public String getEmail() {
        return email;
        }

@JsonProperty("email")
public void setEmail(String email) {
        this.email = email;
        }

@JsonProperty("phone")
public String getPhone() {
        return phone;
        }

@JsonProperty("phone")
public void setPhone(String phone) {
        this.phone = phone;
        }

@JsonProperty("username")
public String getUsername() {
        return username;
        }

@JsonProperty("username")
public void setUsername(String username) {
        this.username = username;
        }

@JsonProperty("password")
public String getPassword() {
        return password;
        }

@JsonProperty("password")
public void setPassword(String password) {
        this.password = password;
        }

@JsonProperty("birthDate")
public String getBirthDate() {
        return birthDate;
        }

@JsonProperty("birthDate")
public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        }

@JsonProperty("image")
public String getImage() {
        return image;
        }

@JsonProperty("image")
public void setImage(String image) {
        this.image = image;
        }

@JsonProperty("bloodGroup")
public String getBloodGroup() {
        return bloodGroup;
        }

@JsonProperty("bloodGroup")
public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
        }

@JsonProperty("height")
public Integer getHeight() {
        return height;
        }

@JsonProperty("height")
public void setHeight(Integer height) {
        this.height = height;
        }

@JsonProperty("weight")
public Double getWeight() {
        return weight;
        }

@JsonProperty("weight")
public void setWeight(Double weight) {
        this.weight = weight;
        }

@JsonProperty("eyeColor")
public String getEyeColor() {
        return eyeColor;
        }

@JsonProperty("eyeColor")
public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
        }

@JsonProperty("hair")
public Hair getHair() {
        return hair;
        }

@JsonProperty("hair")
public void setHair(Hair hair) {
        this.hair = hair;
        }

@JsonProperty("domain")
public String getDomain() {
        return domain;
        }

@JsonProperty("domain")
public void setDomain(String domain) {
        this.domain = domain;
        }

@JsonProperty("ip")
public String getIp() {
        return ip;
        }

@JsonProperty("ip")
public void setIp(String ip) {
        this.ip = ip;
        }

@JsonProperty("address")
public Address getAddress() {
        return address;
        }

@JsonProperty("address")
public void setAddress(Address address) {
        this.address = address;
        }

@JsonProperty("macAddress")
public String getMacAddress() {
        return macAddress;
        }

@JsonProperty("macAddress")
public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
        }

@JsonProperty("university")
public String getUniversity() {
        return university;
        }

@JsonProperty("university")
public void setUniversity(String university) {
        this.university = university;
        }

@JsonProperty("bank")
public Bank getBank() {
        return bank;
        }

@JsonProperty("bank")
public void setBank(Bank bank) {
        this.bank = bank;
        }

@JsonProperty("company")
public Company getCompany() {
        return company;
        }

@JsonProperty("company")
public void setCompany(Company company) {
        this.company = company;
        }

@JsonProperty("ein")
public String getEin() {
        return ein;
        }

@JsonProperty("ein")
public void setEin(String ein) {
        this.ein = ein;
        }

@JsonProperty("ssn")
public String getSsn() {
        return ssn;
        }

@JsonProperty("ssn")
public void setSsn(String ssn) {
        this.ssn = ssn;
        }

@JsonProperty("userAgent")
public String getUserAgent() {
        return userAgent;
        }

@JsonProperty("userAgent")
public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
}

}