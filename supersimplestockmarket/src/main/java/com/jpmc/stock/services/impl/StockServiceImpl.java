package com.jpmc.stock.services.impl;
import com.jpmc.stock.enums.StockTypeEnum;
import com.jpmc.stock.exception.SimpleStockCustomException;
import com.jpmc.stock.models.StockModel;
import com.jpmc.stock.models.TradeModel;
import com.jpmc.stock.services.StockService;
import java.util.List;
/**
 * This is an stock service implementation class and it holds the all calculatin methods
 * @author Koteswara Pininti
 */

public class StockServiceImpl implements StockService {

    /**
     * Calculate the dividend yield for an {@code StockModel} and price
     * @param stock
     * @param price
     * @return double
     */
    public double calculateDividendYield(StockModel stock, double price) throws SimpleStockCustomException {

        if (stock.getType() == StockTypeEnum.COMMON) {
            return stock.getLastDividend() / price;
        } else if (stock.getType() == StockTypeEnum.PREFERRED) {
            return (stock.getFixedDividend() * stock.getParValue()) / price;
        } else {
            return 0.0;
        }
    }

    /**
     * Calculate the PERatio for an {@code StockModel} and price
     * @param stock
     * @param price
     * @return
     */
    public double calculatePERatio(StockModel stock, double price) throws SimpleStockCustomException {
        if (stock.getLastDividend() == 0) {
            return 0;
        } else {
            return price / stock.getLastDividend();
        }
    }
    /**
     * Calculate the volume weighted stock for an {@code List<tradeModel>} and price
     * @param trades
     * @return
     */
    public double calculateVolumeWeightedStockPrice(List<TradeModel> trades) throws SimpleStockCustomException {
        double sumOfPriceQuantity = 0;
        int sumOfQuantity = 0;

        for (TradeModel trade : trades) {

            sumOfPriceQuantity = sumOfPriceQuantity + (trade.getPrice() * trade.getQuantity());
            sumOfQuantity = sumOfQuantity + trade.getQuantity();
        }
        double result = sumOfPriceQuantity / sumOfQuantity;
        return result;
    }

    /**
     * Calculate the GBCE stock price for an {@code List<tradeModel>} and price
     * @param trades
     * @return
     */
    public double calculateGBCEStockPrice(List<TradeModel> trades) throws SimpleStockCustomException {
        double totalShareIndex = 1.0;
        for (TradeModel trade : trades) {
            totalShareIndex = totalShareIndex * trade.getPrice();
        }
        double result = Math.pow(totalShareIndex, (1d / trades.size()));
        return result;
    }


}
