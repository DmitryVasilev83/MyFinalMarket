package ru.vasilev.market.auth.exceptions;

import lombok.Getter;
import ru.vasilev.market.api.ListResponse;
import ru.vasilev.market.api.ValidationError;

@Getter
public class JsonUserFormValidationErrorException extends RuntimeException {

    private final ListResponse<ValidationError> errors;

    public JsonUserFormValidationErrorException(ListResponse<ValidationError> errors) {
        this.errors = errors;
    }
}
