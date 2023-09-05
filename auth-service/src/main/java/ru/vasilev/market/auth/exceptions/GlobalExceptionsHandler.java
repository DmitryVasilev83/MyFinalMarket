package ru.vasilev.market.auth.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.vasilev.market.api.ListResponse;
import ru.vasilev.market.api.ValidationError;

@ControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler
    public ResponseEntity<AppError> handleResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>(new AppError("RESOURCE_NOT_FOUND", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<AppError> handlerIncorrectLoginOrPasswordException(IncorrectLoginOrPasswordException e) {
        return new ResponseEntity<>(new AppError("INCORRECT_USER_DATA", e.getMessage()), HttpStatus.UNAUTHORIZED);
    }

   @ExceptionHandler
    public ResponseEntity<AppError> handlerIncorrectRoleUserException(IncorrectRoleUserException e) {
        return new ResponseEntity<>(new AppError("INCORRECT_USER_DATA", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<AppError> handlerBanUserException(BanUserException e) {
        return new ResponseEntity<>(new AppError("INCORRECT_USER_DATA", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<AppError> handleAccessForbiddenException(AccessForbiddenException e) {
        return new ResponseEntity<>(new AppError("ACCESS_FORBIDDEN", e.getMessage()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler
    public ResponseEntity<ListResponse<ValidationError>> handleUserFormValidationErrorException(JsonUserFormValidationErrorException e) {
        return new ResponseEntity<>(e.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
