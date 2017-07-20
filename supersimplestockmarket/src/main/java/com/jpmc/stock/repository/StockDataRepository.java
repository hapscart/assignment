package com.jpmc.stock.repository;

import com.jpmc.stock.enums.StockTypeEnum;
import com.jpmc.stock.exception.SimpleStockCustomException;
import com.jpmc.stock.models.StockModel;

import java.util.HashMap;
import java.util.Map;

/**
 * This class simulates stock data from backend like retrieving from database, feeds etc., and here it holds the in-memory stock data map
 * @author Koteswara Pininti
 */
public class StockDataRepository {
    Map<String, StockModel> stockData = null;

    public Map<String, StockModel> getStockData() throws SimpleStockCustomException {
        stockData = new HashMap<String, StockModel>();
        stockData.put("TEA", new StockModel("TEA", StockTypeEnum.COMMON, 0.0, 0.0, 100.0));
        stockData.put("POP", new StockModel("POP", StockTypeEnum.COMMON, 8.0, 0.0, 100.0));
        stockData.put("ALE", new StockModel("ALE", StockTypeEnum.COMMON, 23.0, 0.0, 60.0));
        stockData.put("GIN", new StockModel("GIN", StockTypeEnum.PREFERRED, 8.0, 0.2, 100.0));
        stockData.put("JOE", new StockModel("JOE", StockTypeEnum.COMMON, 13.0, 0.0, 250.0));

        return stockData;

    }
}
