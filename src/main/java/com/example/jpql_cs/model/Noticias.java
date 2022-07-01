package com.example.jpql_cs.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
public class Noticias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "noticias", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = true)
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
