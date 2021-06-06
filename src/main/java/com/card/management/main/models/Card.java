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
    private String cardNumber_1;
    private String cardNumber_2;
    private String cardNumber_3;
    private String cardNumber_4;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private int cvv2;
    private int expirationMonth;
    private int expirationYear;
    private String secondPass;

    public Card() {
    }



    public Card(int id, String cardNumber_1, String cardNumber_2, String cardNumber_3, String cardNumber_4, User user, int cvv2, int expirationMonth, int expirationYear, String secondPass) {
        this.id = id;
        this.cardNumber_1 = cardNumber_1;
        this.cardNumber_2 = cardNumber_2;
        this.cardNumber_3 = cardNumber_3;
        this.cardNumber_4 = cardNumber_4;
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

    public String getCardNumber_1() {
        return this.cardNumber_1;
    }

    public void setCardNumber_1(String cardNumber_1) {
        this.cardNumber_1 = cardNumber_1;
    }

    public String getCardNumber_2() {
        return this.cardNumber_2;
    }

    public void setCardNumber_2(String cardNumber_2) {
        this.cardNumber_2 = cardNumber_2;
    }

    public String getCardNumber_3() {
        return this.cardNumber_3;
    }

    public void setCardNumber_3(String cardNumber_3) {
        this.cardNumber_3 = cardNumber_3;
    }

    public String getCardNumber_4() {
        return this.cardNumber_4;
    }

    public void setCardNumber_4(String cardNumber_4) {
        this.cardNumber_4 = cardNumber_4;
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
            ", cardNumber_1='" + getCardNumber_1() + "'" +
            ", cardNumber_2='" + getCardNumber_2() + "'" +
            ", cardNumber_3='" + getCardNumber_3() + "'" +
            ", cardNumber_4='" + getCardNumber_4() + "'" +
            ", user='" + getUser() + "'" +
            ", cvv2='" + getCvv2() + "'" +
            ", expirationMonth='" + getExpirationMonth() + "'" +
            ", expirationYear='" + getExpirationYear() + "'" +
            ", secondPass='" + getSecondPass() + "'" +
            "}";
    }
    

    

}