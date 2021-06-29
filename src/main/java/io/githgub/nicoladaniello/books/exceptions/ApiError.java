package io.githgub.nicoladaniello.books.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

/**
 * Api error response object
 */
public class ApiError {
    private final HttpStatus status;
    private final String message;
    private final List<String> errors;

    public ApiError(final HttpStatus status, final String message) {
        super();
        this.status = status;
        this.message = message;
        this.errors = Collections.emptyList();
    }

    public ApiError(final HttpStatus status, final String message, final List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiError(final HttpStatus status, final String message, final String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Collections.singletonList(error);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }
}