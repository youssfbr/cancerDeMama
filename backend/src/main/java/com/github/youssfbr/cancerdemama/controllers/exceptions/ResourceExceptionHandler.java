package com.github.youssfbr.cancerdemama.controllers.exceptions;

import com.github.youssfbr.cancerdemama.services.exceptions.RegiaoNotFoundException;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErros> handleValidationErrors(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> messages = bindingResult.getAllErrors()
                .stream()
                .map( DefaultMessageSourceResolvable::getDefaultMessage )
                .collect( Collectors.toList() );

        return ResponseEntity.badRequest().body(new ApiErros(messages));
    }

    @ExceptionHandler(RegiaoNotFoundException.class)
    public ResponseEntity<ApiErros> personNotFound(RegiaoNotFoundException e) {

        ApiErros message = getError(HttpStatus.NOT_FOUND, e.getMessage());

        return ResponseEntity.status(message.getStatus()).body(message);
    }

    private ApiErros getError(HttpStatus status, String message) {
        return ApiErros.builder()
                .dataHora(Instant.now())
                .status(status)
                .erros(Arrays.asList(message))
                .build();
    }
}
