package com.card.management.main.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String[] cardNumber;
    
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    private int cvv2;
    private int expirationMonth;
    private int expirationYear;
    private String secondPass;

    public Card() {
    }


    public Card(int id, String[] cardNumber, User user, int cvv2, int expirationMonth, int expirationYear, String secondPass) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.user = user;
        this.cvv2 = cvv2;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.secondPass = secondPass;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String[] cardNumber) {
        this.cardNumber = cardNumber;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCvv2() {
        return this.cvv2;
    }

    public void setCvv2(int cvv2) {
        this.cvv2 = cvv2;
    }

    public int getExpirationMonth() {
        return this.expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public int getExpirationYear() {
        return this.expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getSecondPass() {
        return this.secondPass;
    }

    public void setSecondPass(String secondPass) {
        this.secondPass = secondPass;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", cardNumber='" + getCardNumber() + "'" +
            ", user='" + getUser() + "'" +
            ", cvv2='" + getCvv2() + "'" +
            ", expirationMonth='" + getExpirationMonth() + "'" +
            ", expirationYear='" + getExpirationYear() + "'" +
            ", secondPass='" + getSecondPass() + "'" +
            "}";
    }

    

}