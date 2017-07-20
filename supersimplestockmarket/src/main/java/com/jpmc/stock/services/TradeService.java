package com.jpmc.stock.services;

import com.jpmc.stock.models.StockModel;
import com.jpmc.stock.models.TradeModel;

import java.util.List;

/**
 * Trade service interface
 * @author Koteswara Pininti
 */
public interface TradeService {
    /**
     * Records the trade data for a list of {@code StockModel}
     *
     * @param stock
     * @return List<TradeModel>
     */
    public List<TradeModel> recordTradeData(StockModel stock);
}
