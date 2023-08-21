package ru.vasilev.market.auth.exceptions;

import lombok.Getter;
import ru.vasilev.market.api.ValidationError;
import ru.vasilev.market.api.ValueWrapper;

import java.util.List;

@Getter
public class UserFormValidationErrorException extends RuntimeException {

    private final ValueWrapper<List<ValidationError>> errors;

    public UserFormValidationErrorException(ValueWrapper<List<ValidationError>> errors) {
        this.errors = errors;
    }
}
