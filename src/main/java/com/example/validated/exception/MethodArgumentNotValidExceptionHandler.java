package com.example.validated.exception;

import lombok.Data;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
@RestController
public class MethodArgumentNotValidExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Error onException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getFieldErrors();
        List<String> messages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        String message = StringUtils.join(messages, ';');
        List<ErrorDetails> errors = fieldErrors.stream().map(
                fieldError -> new ErrorDetails(
                        fieldError.getObjectName(),
                        fieldError.getField(),
                        fieldError.getCode(),
                        fieldError.getDefaultMessage()
                )
        ).collect(Collectors.toList());
        return new Error(message, errors);
    }

    @Data
    static class Error {
        private final String exception = MethodArgumentNotValidException.class.getSimpleName();
        private final String message;
        private final List<ErrorDetails> errors;
    }

    @Data
    static class ErrorDetails {
        private final String objectName;
        private final String field;
        private final String code;
        private final String message;
    }
}
