package com.example.jpql_cs.dto;

import com.example.jpql_cs.model.Favorita;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

public class NoticiaDTO {
    private Long id;

    private Favorita favorita;

    private String descricao;

    private String noticia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Favorita getFavorita() {
        return favorita;
    }

    public void setFavorita(Favorita favorita) {
        this.favorita = favorita;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }
}
