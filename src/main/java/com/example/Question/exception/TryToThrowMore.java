package com.example.Question.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TryToThrowMore extends RuntimeException{
    public TryToThrowMore() {
    }

    public TryToThrowMore(String message) {
        super(message);
    }

    public TryToThrowMore(String message, Throwable cause) {
        super(message, cause);
    }

    public TryToThrowMore(Throwable cause) {
        super(cause);
    }

    public TryToThrowMore(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
