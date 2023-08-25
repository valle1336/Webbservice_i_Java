package com.alex.dag1.extras;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bank {

    @JsonProperty("cardExpire")
    private String cardExpire;
    @JsonProperty("cardNumber")
    private String cardNumber;
    @JsonProperty("cardType")
    private String cardType;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("iban")
    private String iban;

    @JsonProperty("cardExpire")
    public String getCardExpire() {
        return cardExpire;
    }

    @JsonProperty("cardExpire")
    public void setCardExpire(String cardExpire) {
        this.cardExpire = cardExpire;
    }

    @JsonProperty("cardNumber")
    public String getCardNumber() {
        return cardNumber;
    }

    @JsonProperty("cardNumber")
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @JsonProperty("cardType")
    public String getCardType() {
        return cardType;
    }

    @JsonProperty("cardType")
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("iban")
    public String getIban() {
        return iban;
    }

    @JsonProperty("iban")
    public void setIban(String iban) {
        this.iban = iban;
    }

}
