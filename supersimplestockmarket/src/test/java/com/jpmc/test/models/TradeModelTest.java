package com.jpmc.test.models;

import com.jpmc.stock.enums.TradeTypeEnum;
import com.jpmc.stock.models.TradeModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * This is a junit Trade model test case class
 * @author Koteswara Pininti
 */
public class TradeModelTest {
    TradeModel tradeModel;

    @Before
    public void setUp() {
        tradeModel = new TradeModel("TEA", new Date(), 10, TradeTypeEnum.BUY, 23.33);
    }

    @Test
    public void testSetAndGetStockSymbol() {
        this.tradeModel.setStockSymbol("TEA");
        Assert.assertEquals("TEA", this.tradeModel.getStockSymbol());
    }

    @Test
    public void testSetAndGetTimeStamp() {
        Date timestamp = new Date();
        this.tradeModel.setTimestamp(timestamp);
        Assert.assertEquals(timestamp, this.tradeModel.getTimestamp());
    }

    @Test
    public void testSetAndGetQuantity() {
        Assert.assertEquals(10, this.tradeModel.getQuantity());
    }

    @Test
    public void testAndGetPrice() {
        Double price = new Double(Math.random() * 20);
        this.tradeModel.setPrice(price);
        Assert.assertEquals(price, this.tradeModel.getPrice());
    }

    @Test
    public void testSetAndGetBuyIndicator() {
        this.tradeModel.setType(TradeTypeEnum.BUY);
        Assert.assertEquals(TradeTypeEnum.BUY, tradeModel.getType());

    }

    @Test
    public void testSetAndGetSellIndicator() {
        this.tradeModel.setType(TradeTypeEnum.SELL);
        Assert.assertEquals(TradeTypeEnum.SELL, tradeModel.getType());

    }

    @Test
    public void testSetAndGetNULLIndicator() {
        this.tradeModel.setType(null);
        Assert.assertNull("No Trade type is specified", null);
    }
}
