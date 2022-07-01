package com.example.jpql_cs.controller;

import com.example.jpql_cs.dto.NoticiaDTO;
import com.example.jpql_cs.model.Noticias;
import com.example.jpql_cs.service.NoticiaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

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
        noticiasRequest.getNoticia();

        //Grava na Memoria
        Noticias noticia = noticiaService.createNoticias(noticiasRequest);
        // convert entity to DTO
        return mapper.map(noticia, NoticiaDTO.class);
    }




}
