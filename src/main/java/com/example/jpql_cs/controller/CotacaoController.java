package com.example.jpql_cs.controller;

import com.example.jpql_cs.model.Cotacao;
import com.example.jpql_cs.model.Favorita;
import com.example.jpql_cs.repository.FavoritosRepository;
import com.example.jpql_cs.repository.CotacaoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class CotacaoController {

    private CotacaoRepository cotacaoRepository;

    private FavoritosRepository favoritosRepository;
    private String url = "https://api.coinpaprika.com/v1/coins";

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("cotacao")
    public List<Cotacao> getAll() {
        Cotacao[] cotacao = restTemplate.getForObject(url, Cotacao[].class);
        return List.of(cotacao);
    }


    @GetMapping("cotacaoSalvas")
    public Favorita convertCotacao(Favorita favoritos) {
        List<Cotacao> cotacaoList = getAll();
        favoritos.setCotacao(cotacaoList);

        return favoritosRepository.save(favoritos);
    }


}
