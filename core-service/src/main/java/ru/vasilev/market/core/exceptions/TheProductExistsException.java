package ru.vasilev.market.core.exceptions;

public class TheProductExistsException extends RuntimeException{
    public TheProductExistsException(String message) {
        super(message);
    }
}
