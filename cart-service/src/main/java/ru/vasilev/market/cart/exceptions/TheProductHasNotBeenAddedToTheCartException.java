package ru.vasilev.market.cart.exceptions;

public class TheProductHasNotBeenAddedToTheCartException extends RuntimeException {
    public TheProductHasNotBeenAddedToTheCartException(String message) {
        super(message);
    }
}
