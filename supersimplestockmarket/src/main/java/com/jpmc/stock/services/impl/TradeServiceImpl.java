package com.jpmc.stock.services.impl;
import com.jpmc.stock.models.StockModel;
import com.jpmc.stock.models.TradeModel;
import com.jpmc.stock.repository.TradeDataRepository;
import com.jpmc.stock.services.TradeService;
import java.util.List;

/**
 * This is an trade service implementation class
 * @author Koteswara Pininti
 */
public class TradeServiceImpl implements TradeService {
    TradeDataRepository tradeDataRepository = null;
    /**
     * Records the trade data for a list of {@code StockModel}
     *
     * @param stock
     * @return List<TradeModel>
     */
    public List<TradeModel> recordTradeData(StockModel stock) {
        tradeDataRepository = new TradeDataRepository();
        return tradeDataRepository.getTradeRecordData(stock);
    }
}
