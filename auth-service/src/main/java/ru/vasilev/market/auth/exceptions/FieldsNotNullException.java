package ru.vasilev.market.auth.exceptions;

public class FieldsNotNullException extends RuntimeException{
    public FieldsNotNullException(String message) {
        super(message);
    }
}
