package com.jpmc.stock.exception;

/**
 * This is simple stock custom exception class
 * @author Koteswara Pininti
 */
public class SimpleStockCustomException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public SimpleStockCustomException(String message) {
        super(message);
    }
}
