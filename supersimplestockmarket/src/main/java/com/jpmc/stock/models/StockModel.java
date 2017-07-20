package com.jpmc.stock.models;
import com.jpmc.stock.enums.StockTypeEnum;
import java.util.List;
/**
 * StockModel class is used to hold the Stock data
 * @author Koteswara Pininti
 */
public class StockModel {
    private String symbol;
    private StockTypeEnum type;
    private Double lastDividend;
    private Double fixedDividend;
    private Double parValue;
    private List<TradeModel> trades;

    public List<TradeModel> getTrades() {
        return trades;
    }

    public void setTrades(List<TradeModel> trades) {
        this.trades = trades;
    }

    public TradeModel getTradeModel() {
        return tradeModel;
    }

    public void setTradeModel(TradeModel tradeModel) {
        this.tradeModel = tradeModel;
    }

    private TradeModel tradeModel;

    public StockModel(String symbol, StockTypeEnum type, Double lastDividend, Double fixedDividend, Double parValue) {
        this.setSymbol(symbol);
        this.setType(type);
        this.setLastDividend(lastDividend);
        this.setFixedDividend(fixedDividend);
        this.setParValue(parValue);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public StockTypeEnum getType() {
        return type;
    }

    public void setType(StockTypeEnum type) {
        this.type = type;
    }

    public Double getLastDividend() {
        return lastDividend;
    }

    public void setLastDividend(Double lastDividend) {
        this.lastDividend = lastDividend;
    }

    public Double getFixedDividend() {
        return fixedDividend;
    }

    public void setFixedDividend(Double fixedDividend) {
        this.fixedDividend = fixedDividend;
    }

    public Double getParValue() {
        return parValue;
    }

    public void setParValue(Double parValue) {
        this.parValue = parValue;
    }

    public void addTradeRecord(TradeModel trade) {
        this.trades.add(trade);
    }


}
