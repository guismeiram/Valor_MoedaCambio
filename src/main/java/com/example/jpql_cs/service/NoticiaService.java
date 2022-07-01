package com.example.jpql_cs.service;

import com.example.jpql_cs.exception.JpqlNotFoundException;
import com.example.jpql_cs.model.Favorita;
import com.example.jpql_cs.model.Noticias;
import com.example.jpql_cs.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class NoticiaService {
    @Autowired
    private NoticiaRepository noticiaRepository;

    @Transactional
    public Noticias createNoticias(Noticias noticias) {
        return noticiaRepository.save(noticias);
    }

    public List<Noticias> getAllNoticias() {
        return noticiaRepository.findAll();
    }

    public Noticias getNoticiasById(long id) throws JpqlNotFoundException {
        Optional<Noticias> result = noticiaRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }else{
            throw new ResourceNotFoundException();
        }
    }

    public void deleteNoticia(long id)  throws JpqlNotFoundException {
        Noticias noticias = noticiaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        noticiaRepository.delete(noticias);
    }
}
