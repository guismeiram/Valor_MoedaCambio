package com.example.jpql_cs.controller;

import com.example.jpql_cs.service.NoticiaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticiaController {
    @Autowired
    private NoticiaService noticiaService;

    @Autowired
    private final ModelMapper modelMapper;

    public NoticiaController(ModelMapper modelMapper, NoticiaService noticiaService) {
        this.modelMapper = modelMapper;
        this.noticiaService = noticiaService;
    }
}
