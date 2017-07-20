package com.jpmc.test.repository;

import com.jpmc.stock.enums.StockTypeEnum;
import com.jpmc.stock.models.StockModel;
import com.jpmc.stock.repository.TradeDataRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * * This is a junit Trade Data Repository unit test class
 * @author Koteswara Pininti
 */
public class TradeDataRepositoryTest {
    public class StockDataRepositoryTest {
        private StockModel stock;
        private TradeDataRepository tradeDataRepository = null;

        @Before
        public void setUp() {
            tradeDataRepository = new TradeDataRepository();
            this.stock = new StockModel("TEA", StockTypeEnum.COMMON, 23.0, 0.0, 60.0);
        }

        @Test
        public void testGetTradeRecordData() {
            Assert.assertTrue("Trade records data contains one or more records...", tradeDataRepository.getTradeRecordData(stock).size() > 0);
        }

    }
}
