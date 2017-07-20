package com.jpmc.test.models;

import com.jpmc.stock.enums.StockTypeEnum;
import com.jpmc.stock.models.StockModel;
import com.jpmc.stock.models.TradeModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a junit Stock model test case class
 * @author Koteswara Pininti
 */
public class StockModelTest {
    private StockModel stock;

    public static final String PREFIX_COMMON_STOCK = "COMMON";
    public static final String PREFIX_PREFERRED_STOCK = "PREFERRED";

    @Spy
    private List<TradeModel> tradesList = new ArrayList<TradeModel>();

    @Before
    public void setUp() {
        this.stock = new StockModel("TEA", StockTypeEnum.COMMON, 23.0, 0.0, 60.0);
    }

    @Test
    public void testSetAndGetSymbol() {
        this.stock.setSymbol("ALE");
        Assert.assertEquals("ALE", this.stock.getSymbol());
    }

    @Test
    public void testSetAndGetParValue() {
        Double value = new Double(Math.random() * 1000);
        this.stock.setParValue(value);
        Assert.assertEquals(value, stock.getParValue());
    }

    @Test
    public void testSetAndGetCommonStockType() {
        this.stock.setType(StockTypeEnum.COMMON);
        Assert.assertEquals(StockTypeEnum.COMMON, stock.getType());

    }

    @Test
    public void testSetAndGetPreferedStockType() {
        this.stock.setType(StockTypeEnum.PREFERRED);
        Assert.assertEquals(StockTypeEnum.PREFERRED, stock.getType());

    }

    @Test
    public void testSetAndGetFixedDividend() {
        Double value = new Double(Math.random() * 10);
        this.stock.setFixedDividend(value);
        Assert.assertEquals(value, this.stock.getFixedDividend());
    }

    @Test
    public void testSetAndGetLastDividend() {
        Double value = new Double(Math.random() * 20);
        this.stock.setLastDividend(value);
        Assert.assertEquals(value, this.stock.getLastDividend());
    }

    @Test
    public void testSetAndGetRecordTradeList() {

        TradeModel tradeRecord = Mockito.mock(TradeModel.class);
        tradesList.add(tradeRecord);
        stock.setTrades(tradesList);
        Assert.assertEquals(tradeRecord, this.stock.getTrades().get(0));
        Assert.assertTrue("List contains records", this.stock.getTrades().size() > 0);
    }
}
