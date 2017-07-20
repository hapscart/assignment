package com.jpmc.stock.cli;

import com.jpmc.stock.exception.SimpleStockCustomException;
import com.jpmc.stock.models.StockModel;
import com.jpmc.stock.models.TradeModel;
import com.jpmc.stock.repository.StockDataRepository;
import com.jpmc.stock.services.StockService;
import com.jpmc.stock.services.TradeService;
import com.jpmc.stock.services.impl.StockServiceImpl;
import com.jpmc.stock.services.impl.TradeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * This is Simple Stock Market main class and it executes the main program
 * @author Koteswara Pininti
 */

@Configuration
@ComponentScan
public class SimpleStockAPPCLI {

    @Bean(name = "stockData1")
    public Map<String, StockModel> retrieveStockData() {
        StockDataRepository stockDataRepository = new StockDataRepository();
        return stockDataRepository.getStockData();
    }

    public static void main(String[] args) {

        System.out.println("======================================================================");
        System.out.println("Simple Stock Market Application CLI is running");
        System.out.println("======================================================================");

        try {
            StockService stockService = new StockServiceImpl();
            TradeService tradeService = new TradeServiceImpl();
            ApplicationContext context = new AnnotationConfigApplicationContext(SimpleStockAPPCLI.class);
            //retrieving the stock data from in-memory stock repository
            //Map<String, StockModel> stockData = context.getBean("stockData1",Map.class);
            StockDataRepository stockDataRepository = new StockDataRepository();
            Map<String, StockModel> stockDataMap =  stockDataRepository.getStockData();

            for (StockModel stock : stockDataMap.values()) {
                //Calculating the Dividend yeild ad PERation for given stock type and symbol
                System.out.println("Stock Symbol : " + stock.getSymbol() + " and its stock type : " + stock.getType());
                System.out.println("Divident yield ::: " + stockService.calculateDividendYield(stock, 8.9));
                System.out.println("PE Ratio ::: " + stockService.calculatePERatio(stock, 8.9));
                //invoked the trade record data and set to the stock model
                if (tradeService.recordTradeData(stock).size() > 0) {
                    stock.setTrades(tradeService.recordTradeData(stock));

                    // Record the trades data
                    List<TradeModel> tradesList = stock.getTrades();

                    //Current thread is sleeping 1 second
                    TimeUnit.SECONDS.sleep(1);

                    //Calculating the Volume Weighted Stock Price
                    if (tradesList == null || tradesList.isEmpty() || tradesList.size() == 0) {
                        System.out.println("Volume Weighted Stock Price: No trades");
                    } else {
                        double result = stockService.calculateVolumeWeightedStockPrice(tradesList);
                        System.out.println("Volume Weighted Stock Price: " + result);
                    }

                    //calculate GBCE for All Share Index
                    if (tradesList == null || tradesList.isEmpty() || tradesList.size() == 0) {
                        System.out.println("Unable to calculate GBCE: No trades");
                    } else {
                        double result = stockService.calculateGBCEStockPrice(tradesList);
                        System.out.println("GBCE: " + result);
                    }

                }//if
            }//for
        } catch (SimpleStockCustomException excep) {
            System.out.println("Error occured while running Stock Market Application  --- " + excep.getMessage());
        } catch (InterruptedException interexcep) {
            System.out.println("Interrupted error occured while running the stock market application --- " + interexcep.getMessage());
        }
    }
}
