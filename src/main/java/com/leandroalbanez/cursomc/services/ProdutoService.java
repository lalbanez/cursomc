package com.leandroalbanez.cursomc.services;

import com.leandroalbanez.cursomc.domain.Categoria;
import com.leandroalbanez.cursomc.domain.Pedido;
import com.leandroalbanez.cursomc.domain.Produto;
import com.leandroalbanez.cursomc.repositories.CategoriaRepository;
import com.leandroalbanez.cursomc.repositories.ProdutoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;
    @Autowired
    CategoriaRepository categoriaRepository;

    public Produto find(Integer id){
        Optional<Produto> pedido = repository.findById(id);
        return pedido.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id
                + " Tipo: " + Pedido.class.getName(),Pedido.class));
    }

    public Page<Produto> search (String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        List<Categoria> categorias = categoriaRepository.findAllById(ids);
        return repository.search(nome, categorias, pageRequest);
    }
}
