package com.example.jpql_cs.dto;

import com.example.jpql_cs.model.Cotacao;
import com.example.jpql_cs.model.Noticias;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FavoritaDTO {
    private Long id;
    private LocalDate created = LocalDate.now();
    private LocalTime updated = LocalTime.now(); //data de atualização do favorito
    private List<Cotacao> cotacao = new ArrayList<>();
    private Noticias noticias;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalTime updated) {
        this.updated = updated;
    }

    public List<Cotacao> getCotacao() {
        return cotacao;
    }

    public void setCotacao(List<Cotacao> cotacao) {
        this.cotacao = cotacao;
    }

    public Noticias getNoticias() {
        return noticias;
    }

    public void setNoticias(Noticias noticias) {
        this.noticias = noticias;
    }
}
