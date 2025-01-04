package com.leandroalbanez.cursomc.services;

import com.leandroalbanez.cursomc.domain.Categoria;
import com.leandroalbanez.cursomc.repositories.CategoriaRepository;
import com.leandroalbanez.cursomc.services.exception.DataIntegrityException;
import com.leandroalbanez.cursomc.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public Categoria find(Integer id) {
        Optional<Categoria> categoria = repository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id
                + " Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Categoria obj) {
        find(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma categoria com Produtos");
        }
    }
}

