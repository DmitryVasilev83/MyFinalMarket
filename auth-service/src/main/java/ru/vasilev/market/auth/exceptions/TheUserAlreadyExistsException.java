package ru.vasilev.market.auth.exceptions;

public class TheUserAlreadyExistsException extends RuntimeException{
    public TheUserAlreadyExistsException(String message) {
        super(message);
    }
}
