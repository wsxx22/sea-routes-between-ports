package com.searoutes.config.exceptions;

import com.searoutes.model.Error;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(FileNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public Error fileNotFoundException() {
        return Error.builder()
            .code(HttpStatus.UNPROCESSABLE_ENTITY.value())
            .userMessage("Plik nie został odnaleziony")
            .build();
    }

    @ExceptionHandler(PathNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public Error pathNotFoundException() {
        return Error.builder()
            .code(HttpStatus.UNPROCESSABLE_ENTITY.value())
            .userMessage("Scieżka do pliku nie została odnaleziona")
            .build();
    }

    @ExceptionHandler(HistoricalRouteNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public Error historicalRouteNotFoundException() {
        return Error.builder()
            .code(HttpStatus.NOT_FOUND.value())
            .userMessage("Nie można znaleźć szlaku morskiego z podanym parametrem")
            .build();
    }
}
