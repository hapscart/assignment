package com.jpmc.stock.repository;
import com.jpmc.stock.enums.TradeTypeEnum;
import com.jpmc.stock.exception.SimpleStockCustomException;
import com.jpmc.stock.models.StockModel;
import com.jpmc.stock.models.TradeModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
/**
 * This class simulates trade data from backend like retrieving from database, feeds etc., and here it holds the in-memory record trades data List
 * @author Koteswara Pininti
 */
public class TradeDataRepository {

    public List<TradeModel> getTradeRecordData(StockModel stock) throws SimpleStockCustomException {
        List<TradeModel> tradeDataList = new ArrayList<TradeModel>();
        int minutes = 15;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, +minutes);

        Random random = new Random();
        // generate a random integer from 0 to 899, then add 100
        int price = random.nextInt(900) + 50;
        int quantityOfShares = random.nextInt(900) + 100;
        tradeDataList.add(new TradeModel(stock.getSymbol(), calendar.getTime(), quantityOfShares, TradeTypeEnum.BUY, price));
        tradeDataList.add(new TradeModel(stock.getSymbol(), calendar.getTime(), quantityOfShares, TradeTypeEnum.SELL, price));
        tradeDataList.add(new TradeModel(stock.getSymbol(), calendar.getTime(), quantityOfShares, TradeTypeEnum.BUY, price));
        tradeDataList.add(new TradeModel(stock.getSymbol(), calendar.getTime(), quantityOfShares, TradeTypeEnum.SELL, price));
        tradeDataList.add(new TradeModel(stock.getSymbol(), calendar.getTime(), quantityOfShares, TradeTypeEnum.BUY, price));

        return tradeDataList;
    }
}
