package com.example.jpql_cs.controller;

import com.example.jpql_cs.dto.FavoritaDTO;
import com.example.jpql_cs.model.Favorita;
import com.example.jpql_cs.service.FavoritaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController("/api/favoritos")
public class FavoritoController {
    @Autowired
    private FavoritaService favoritaService;

    @Autowired
    private final ModelMapper mapper;

    public FavoritoController(ModelMapper mapper, FavoritaService favoritaService) {
        this.mapper = mapper;
        this.favoritaService = favoritaService;
    }

    @PostMapping
    @Transactional
    public FavoritaDTO createConsulta(@RequestBody FavoritaDTO favoritaDTO)
    {
        Favorita favoritaRequest = mapper.map(favoritaDTO, Favorita.class);
        //favorito
        favoritaRequest.getCotacao().forEach(f ->f.setFavorita(f.getFavorita()));
        favoritaRequest.getCreated();
        favoritaRequest.getUpdated();
        favoritaRequest.getNoticias();



        //Grava na Memoria
         Favorita favorita = favoritaService.createFavorita(favoritaRequest);
        // convert entity to DTO
        return mapper.map(favorita, FavoritaDTO.class);
    }

}
