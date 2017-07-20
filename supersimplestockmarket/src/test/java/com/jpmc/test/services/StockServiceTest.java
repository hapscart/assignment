package com.jpmc.test.services;

import com.jpmc.stock.enums.StockTypeEnum;
import com.jpmc.stock.enums.TradeTypeEnum;
import com.jpmc.stock.models.StockModel;
import com.jpmc.stock.models.TradeModel;
import com.jpmc.stock.services.StockService;
import com.jpmc.stock.services.impl.StockServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Koteswara Pininti
 */
public class StockServiceTest {
    private StockModel stock1;
    private StockModel stock2;
    private StockModel stock3;
    private StockService stockService;
    private static final double DELTA = 1e-15;
    @Spy
    private List<TradeModel> tradesList = new ArrayList<TradeModel>();

    @Before
    public void setUp() {

        this.stock1 = new StockModel("TEA", StockTypeEnum.COMMON, 2.2, 0.0, 60.0);
        this.stock2 = new StockModel("ALE", StockTypeEnum.PREFERRED, 2.5, 0.0, 90.0);
        this.stock3 = new StockModel("TEA", StockTypeEnum.COMMON, 4.9, 0.0, 30.0);
        stockService = new StockServiceImpl();
    }

    @Test
    public void testPreferredStockType() {
        Assert.assertEquals(StockTypeEnum.PREFERRED, stock2.getType());
    }

    @Test
    public void testCommonStockType() {

        Assert.assertEquals(StockTypeEnum.COMMON, stock1.getType());
    }

    @Test
    public void testCalculateDividendYield() {
        double result = stockService.calculateDividendYield(stock1, 9.9);
        System.out.println(result);
        Assert.assertEquals(0.22222222222222224, result, DELTA);
    }


    @Test
    public void testCalculateFixedDividendYield() {
        double result = stockService.calculateDividendYield(stock2, 9.9);
        System.out.println(result);
        Assert.assertEquals(StockTypeEnum.PREFERRED, stock2.getType());
        Assert.assertEquals(0.0, result, DELTA);
    }

    @Test
    public void testCalculatePERatio() {
        double result = stockService.calculatePERatio(stock1, 9.9);
        Assert.assertEquals(4.5, result, DELTA);
    }

    @Test
    public void testCalculateVolumeWeightedStockPrice() {
        List<TradeModel> trades = new ArrayList<TradeModel>();
        trades.add(new TradeModel(stock1.getSymbol(), Calendar.getInstance().getTime(), 1, TradeTypeEnum.BUY, 2.9));
        trades.add(new TradeModel(stock1.getSymbol(), Calendar.getInstance().getTime(), 3, TradeTypeEnum.BUY, 1.5));
        trades.add(new TradeModel(stock1.getSymbol(), Calendar.getInstance().getTime(), 1, TradeTypeEnum.BUY, 3.9));
        Assert.assertEquals(2.2600000000000002, stockService.calculateVolumeWeightedStockPrice(trades), 0);

    }

    @Test
    public void testCalculateGBCEStockPrice() {
        List<TradeModel> trades = new ArrayList<TradeModel>();
        trades.add(new TradeModel(stock1.getSymbol(), Calendar.getInstance().getTime(), 1, TradeTypeEnum.BUY, 2.1));
        trades.add(new TradeModel(stock2.getSymbol(), Calendar.getInstance().getTime(), 3, TradeTypeEnum.BUY, 1.5));
        trades.add(new TradeModel(stock3.getSymbol(), Calendar.getInstance().getTime(), 1, TradeTypeEnum.BUY, 3.7));
        Assert.assertEquals(2.267274442939176, stockService.calculateGBCEStockPrice(trades), 0);
    }
}
