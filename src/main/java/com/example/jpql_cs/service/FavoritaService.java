package com.example.jpql_cs.service;

import com.example.jpql_cs.exception.JpqlNotFoundException;
import com.example.jpql_cs.model.Favorita;
import com.example.jpql_cs.repository.FavoritosRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FavoritaService {
    private FavoritosRepository favoritosRepository;

    @Transactional
    public Favorita createFavorita(Favorita favorita) {
        return favoritosRepository.save(favorita);
    }

    public List<Favorita> getAllFavorito() {
        return favoritosRepository.findAll();
    }

    public Favorita getFavoritoById(long id) throws JpqlNotFoundException{
        Optional<Favorita> result = favoritosRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }else{
            throw new ResourceNotFoundException();
        }
    }

    public void deleteFavorito(long id)  throws JpqlNotFoundException {
        Favorita favorita = favoritosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        favoritosRepository.delete(favorita);
    }

    public Favorita updateById(Long id, Favorita favoritaRequest) throws JpqlNotFoundException{
        Favorita favorita = favoritosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        favorita.setUpdated(favoritaRequest.getUpdated());
        favorita.setCreated(favoritaRequest.getCreated());
        favorita.setNoticias(favoritaRequest.getNoticias());

        return favorita;
    }


}
