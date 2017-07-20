package com.jpmc.test.repository;

import com.jpmc.stock.enums.StockTypeEnum;
import com.jpmc.stock.models.StockModel;
import com.jpmc.stock.repository.StockDataRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a junit Stock Data Repository unit test class
 * @author Koteswara Pininti
 */
public class StockDataRepositoryTest {
    private StockModel stock;
    private StockDataRepository stockDataRepository = null;

    @Before
    public void setUp() {
        stockDataRepository = new StockDataRepository();
        this.stock = new StockModel("TEA", StockTypeEnum.COMMON, 23.0, 0.0, 60.0);
    }

    @Test
    public void testGetStockData() {
        Assert.assertTrue("Stock data contains one or more records...", stockDataRepository.getStockData().size() > 0);
    }

}
