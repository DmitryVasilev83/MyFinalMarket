package ru.vasilev.market.comment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler
    public ResponseEntity<AppError> handleFieldsNotFoundException(FieldsNotNullException e) {
        return new ResponseEntity<>(new AppError("ILLEGAL_DATA_STATE", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
