package com.cognizant.ormlearn.service.exception;

/**
 * Custom exception thrown when a country lookup by code
 * does not find any matching record in the database.
 */
public class CountryNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    /** Constructs a new exception with a default message. */
    public CountryNotFoundException() {
        super("The requested country was not found in the database");
    }

    /**
     * Constructs a new exception with a descriptive message.
     *
     * @param message detail about the missing country
     */
    public CountryNotFoundException(String message) {
        super(message);
    }
}
