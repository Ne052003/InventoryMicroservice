package com.neoapps.entry_points.exceptions;

import com.neoapps.driven_adapters.exceptions.RepositoryException;
import com.neoapps.exceptions.DomainException;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerException {

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

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlerRepositoryException(RepositoryException exception) {
        String message = exception.getMessage();
        String field = exception.getField();

        Map<String, String> errors = new HashMap<>();

        errors.put("Entity", field);

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
