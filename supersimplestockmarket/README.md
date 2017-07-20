# JP Morgan - Super Simple Stock Market

# Requirements
1. Provide working source code that will :-
a.	For a given stock,
i.	Given any price as input, calculate the dividend yield
ii.	Given any price as input,  calculate the P/E Ratio
iii.	Record a trade, with timestamp, quantity of shares, buy or sell indicator and traded price
iv.	Calculate Volume Weighted Stock Price based on trades in past 15 minutes
b.	Calculate the GBCE All Share Index using the geometric mean of prices for all stocks

# High Level Design
This is a stock market cli application and follows the layered Architectural patten and the layers ae CLI (presentation layer), Service layer, repository layers and all data passed via models.

a. Stock Model is base model and Stock Model and Trade Model follows has-a relationship (composition)
b. Stock service and TradeService follows Single responsiblity principle
c. repsoitory layer mimics the in-memory stock/trade data and it acts like data layer.

From high level view flow follows ss CLI (UI layer) ---> Service layer ---> repository layers and data passed through model from repository layer to service layer and to UI layer
For example if we introduce MVC then other service layer and repository (mock in-memory data layer) layers can remain same
# Build through maven:
mvn clean install

# Executing junit test cases
mvn test

# Run through executable jar:
java -jar supersimplestockmarket-1.0-SNAPSHOT-jar-with-dependencies.jar





