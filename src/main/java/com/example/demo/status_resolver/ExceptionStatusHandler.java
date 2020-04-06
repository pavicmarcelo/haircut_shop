package com.example.demo.status_resolver;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExceptionStatusHandler extends RuntimeException{


        public ExceptionStatusHandler() {
            super();
        }
        public ExceptionStatusHandler(String message, Throwable cause) {
            super(message, cause);
        }
        public ExceptionStatusHandler(String message) {
            super(message);
        }
        public ExceptionStatusHandler(Throwable cause) {
            super(cause);
        }
    }

