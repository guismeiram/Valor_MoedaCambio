package com.example.jpql_cs.controller;

import com.example.jpql_cs.service.FavoritaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FavoritoController {
    @Autowired
    private FavoritaService favoritaService;

    @Autowired
    private final ModelMapper modelMapper;

    public FavoritoController(ModelMapper modelMapper, FavoritaService favoritaService) {
        this.modelMapper = modelMapper;
        this.favoritaService = favoritaService;
    }

    
}
