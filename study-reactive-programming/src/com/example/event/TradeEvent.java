package com.example.event;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public record TradeEvent(String symbol, double price, double quantity) {
}
