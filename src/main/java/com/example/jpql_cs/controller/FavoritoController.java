package com.example.jpql_cs.controller;

import com.example.jpql_cs.dto.FavoritaDTO;
import com.example.jpql_cs.exception.JpqlNotFoundException;
import com.example.jpql_cs.model.Favorita;
import com.example.jpql_cs.service.FavoritaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public List<FavoritaDTO> getAllImovels() {

        return favoritaService.getAllFavorito().stream().map(post -> mapper.map(post, FavoritaDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FavoritaDTO> getFavoritoById(@PathVariable(name = "id") Long id) throws JpqlNotFoundException{
        Favorita favorito = favoritaService.getFavoritoById(id);

        // convert entity to DTO
        FavoritaDTO favoritaResponse = mapper.map(favorito, FavoritaDTO.class);

        return ResponseEntity.ok().body(favoritaResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFavorito(@PathVariable(name = "id") Long id) throws JpqlNotFoundException {
        favoritaService.deleteFavorito(id);

    }

    @PutMapping("/{id}")
    public ResponseEntity<FavoritaDTO> updateImovel(@RequestBody FavoritaDTO favoritaDTO, @PathVariable long id) throws JpqlNotFoundException {
        Favorita favoritaRequest = mapper.map(favoritaDTO, Favorita.class);

        Favorita favorita = favoritaService.updateById(id, favoritaRequest);

        // convert entity to DTO
        FavoritaDTO favoritaResponse = mapper.map(favorita, FavoritaDTO.class);

        return ResponseEntity.ok().body(favoritaResponse);
    }


}
