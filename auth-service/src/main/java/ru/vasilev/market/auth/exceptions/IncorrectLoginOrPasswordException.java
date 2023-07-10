package ru.vasilev.market.auth.exceptions;

public class IncorrectLoginOrPasswordException extends RuntimeException{
    public IncorrectLoginOrPasswordException(String message) {
        super(message);
    }
}
