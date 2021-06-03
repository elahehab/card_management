package com.card.management.main.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Card sourceCard;

    @ManyToOne
    private Card destinationCard;
    private int amount;
    private Date transactionDate;
    private Status transactionResult;

    private enum Status {
        START,
        TRNS_DONE,
        SMS_SENT,
        SMS_RECIEVED,
        SUCCESS,
        FAIL
    };


    public Transaction() {
        
    }

    public Transaction(Card sourceCard, Card destinationCard, int amount, Date transactionDate) {
        this.sourceCard = sourceCard;
        this.destinationCard = destinationCard;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Card getSourceCard() {
        return this.sourceCard;
    }

    public void setSourceCard(Card sourceCard) {
        this.sourceCard = sourceCard;
    }

    public Card getDestinationCard() {
        return this.destinationCard;
    }

    public void setDestinationCard(Card destinationCard) {
        this.destinationCard = destinationCard;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Status getTransactionResult() {
        return this.transactionResult;
    }

    public void setTransactionResult(Status transactionResult) {
        this.transactionResult = transactionResult;
    }

    public Transaction sourceCard(Card sourceCard) {
        setSourceCard(sourceCard);
        return this;
    }

    public Transaction destinationCard(Card destinationCard) {
        setDestinationCard(destinationCard);
        return this;
    }

    public Transaction amount(int amount) {
        setAmount(amount);
        return this;
    }

    public Transaction transactionDate(Date transactionDate) {
        setTransactionDate(transactionDate);
        return this;
    }


    public Transaction transactionResult(Status transactionResult) {
        setTransactionResult(transactionResult);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " sourceCard='" + getSourceCard() + "'" +
            ", destinationCard='" + getDestinationCard() + "'" +
            ", amount='" + getAmount() + "'" +
            ", transactionDate='" + getTransactionDate() + "'" +
            "}";
    }


}
