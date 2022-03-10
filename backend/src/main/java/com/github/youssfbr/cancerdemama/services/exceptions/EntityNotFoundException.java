package com.github.youssfbr.cancerdemama.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(Long id) {
        super("Registro com ID: " + id + " não encontrado.");
    }
}
