package ru.vasilev.market.core.exceptions;

public class FieldsNotNullException extends RuntimeException{
    public FieldsNotNullException(String message) {
        super(message);
    }
}
