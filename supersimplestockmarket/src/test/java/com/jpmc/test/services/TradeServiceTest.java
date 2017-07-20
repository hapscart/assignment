package com.jpmc.test.services;

import com.jpmc.stock.enums.StockTypeEnum;
import com.jpmc.stock.models.StockModel;
import com.jpmc.stock.repository.TradeDataRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Koteswara Pininti
 */
public class TradeServiceTest {
    //TradeDataRepository tradeDataRepository = Mockito.mock(TradeDataRepository.class);
    private StockModel stock;
    private TradeDataRepository tradeDataRepository = null;


    @Before
    public void setUp() {
        tradeDataRepository = new TradeDataRepository();
        this.stock = new StockModel("TEA", StockTypeEnum.COMMON, 23.0, 0.0, 60.0);
    }

    @Test
    public void testRecordTradeData() {
        Assert.assertTrue("Trade record list contains one or more stock data", tradeDataRepository.getTradeRecordData(stock).size() > 0);
    }


}
