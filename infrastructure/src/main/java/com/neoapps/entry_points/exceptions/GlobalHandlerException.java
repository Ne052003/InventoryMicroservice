package com.neoapps.entry_points.exceptions;

import com.neoapps.exceptions.DomainException;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlerValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(
                fieldError -> {

                    String field = fieldError.getField();
                    String message = fieldError.getDefaultMessage();

                    errors.put(field, message);
                }
        );

        ErrorResponse errorResponse = ErrorResponse.builder()
                .message("Parámetros incorrectos")
                .errors(errors)
                .timeStamp(LocalDateTime.now())
                .build();

        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlerDomainException(DomainException exception) {
        String message = exception.getMessage();
        String field = exception.getField();

        Map<String, String> errors = new HashMap<>();

        errors.put("Field", field);

        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(message)
                .errors(errors)
                .timeStamp(LocalDateTime.now())
                .build();

        return ResponseEntity.badRequest().body(errorResponse);

    }

    @Builder
    @Getter
    public static class ErrorResponse {
        private String message;
        private LocalDateTime timeStamp;
        private Map<String, String> errors;
    }
}
