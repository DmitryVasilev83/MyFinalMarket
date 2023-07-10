package ru.vasilev.market.auth.exceptions;

public class BanUserException extends RuntimeException {
    public BanUserException(String message) {
        super(message);
    }
}
