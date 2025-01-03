package com.leandroalbanez.cursomc.services;

import com.leandroalbanez.cursomc.domain.Categoria;
import com.leandroalbanez.cursomc.repositories.CategoriaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public Categoria buscar(Integer id){
        Optional<Categoria> categoria = repository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id
                + " Tipo: " + Categoria.class.getName(),Categoria.class));
    }
}
