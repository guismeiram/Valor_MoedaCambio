package com.example.jpql_cs.controller;

import com.example.jpql_cs.dto.FavoritaDTO;
import com.example.jpql_cs.dto.NoticiaDTO;
import com.example.jpql_cs.exception.JpqlNotFoundException;
import com.example.jpql_cs.model.Favorita;
import com.example.jpql_cs.model.Noticias;
import com.example.jpql_cs.service.NoticiaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class NoticiaController {
    @Autowired
    private NoticiaService noticiaService;

    @Autowired
    private final ModelMapper mapper;

    public NoticiaController(ModelMapper mapper, NoticiaService noticiaService) {
        this.mapper = mapper;
        this.noticiaService = noticiaService;
    }

    @PostMapping
    @Transactional
    public NoticiaDTO createConsulta(@RequestBody  NoticiaDTO  noticiaDTO)
    {
        Noticias noticiasRequest = mapper.map(noticiaDTO, Noticias.class);
        //noticias
        noticiasRequest.getFavorita().getUpdated();
        noticiasRequest.getFavorita().getCreated();
        noticiasRequest.getFavorita().getCotacao();
        noticiasRequest.getDescricao();
        noticiasRequest.getInformacoes();

        //Grava na Memoria
        Noticias noticia = noticiaService.createNoticias(noticiasRequest);
        // convert entity to DTO
        return mapper.map(noticia, NoticiaDTO.class);
    }

    @GetMapping
    public List<NoticiaDTO> getAllImovels() {

        return noticiaService.getAllNoticias().stream().map(noticias -> mapper.map(noticias, NoticiaDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoticiaDTO> getFavoritoById(@PathVariable(name = "id") Long id) throws JpqlNotFoundException {
        Noticias noticias = noticiaService.getNoticiasById(id);

        // convert entity to DTO
        NoticiaDTO noticiaResponse = mapper.map(noticias, NoticiaDTO.class);

        return ResponseEntity.ok().body(noticiaResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFavorito(@PathVariable(name = "id") Long id) throws JpqlNotFoundException {
        noticiaService.deleteNoticia(id);

    }

    @PutMapping("/{id}")
    public ResponseEntity<NoticiaDTO> updateImovel(@RequestBody NoticiaDTO noticiasDTO, @PathVariable long id) throws JpqlNotFoundException {
        Noticias noticiaRequest = mapper.map(noticiasDTO, Noticias.class);

        Noticias noticias = noticiaService.updateById(id, noticiaRequest);

        // convert entity to DTO
        NoticiaDTO noticiaResponse = mapper.map(noticias, NoticiaDTO.class);

        return ResponseEntity.ok().body(noticiaResponse);
    }


}
