package com.jpmc.stock.models;

import com.jpmc.stock.enums.TradeTypeEnum;

import java.util.Date;

/**
 * ThreadModel class holds the trades data
 * @author Koteswara Pininti
 */

public class TradeModel {

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    private String stockSymbol;
    private Date timestamp;
    private int quantityOfShares;
    private TradeTypeEnum type;
    private Double price;


    public TradeModel(String stockSymbol, Date timestamp, int quantityOfShares, TradeTypeEnum type, double price) {
        this.stockSymbol = stockSymbol;
        this.timestamp = timestamp;
        this.quantityOfShares = quantityOfShares;
        this.type = type;
        this.price = price;
    }


    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getQuantity() {
        return quantityOfShares;
    }

    public void setQuantity(int quantity) {
        this.quantityOfShares = quantityOfShares;
    }

    public TradeTypeEnum getType() {
        return type;
    }

    public void setType(TradeTypeEnum type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
