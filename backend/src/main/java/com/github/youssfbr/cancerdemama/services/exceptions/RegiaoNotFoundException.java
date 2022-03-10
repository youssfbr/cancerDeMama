package com.github.youssfbr.cancerdemama.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RegiaoNotFoundException extends Exception {

    public RegiaoNotFoundException(Long id) {
        super("Região não encontrada com ID: " + id);
    }
}
