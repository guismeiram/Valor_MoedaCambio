package com.example.jpql_cs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JpqlNotFoundException extends Exception{

    public JpqlNotFoundException(Long id) {
        super("Imovel not found with ID " + id);
    }
}
