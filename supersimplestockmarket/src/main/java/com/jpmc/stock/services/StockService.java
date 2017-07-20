package com.jpmc.stock.services;

import com.jpmc.stock.models.StockModel;
import com.jpmc.stock.models.TradeModel;

import java.util.List;

/**
 * Stock service interface
 * @author Koteswara Pininti
 */
public interface StockService {

    /**
     * Calculate the dividend yield for an {@code Stock} and price
     *
     * @param stock
     * @param price
     * @return
     */
    public double calculateDividendYield(StockModel stock, double price);

    /**
     * Calculate the P/E ration for an {@code Stock} and price
     *
     * @param stock
     * @param price
     * @return
     */
    public double calculatePERatio(StockModel stock, double price);

    /**
     * Calculate the volume weighted stock price based on a list of {@code Trades}
     *
     * @param trades
     * @return
     */
    public double calculateVolumeWeightedStockPrice(List<TradeModel> trades);

    /**
     * Calculate the GBCE for a list of {@code Trades}
     *
     * @param trades
     * @return
     */
    public double calculateGBCEStockPrice(List<TradeModel> trades);
}
