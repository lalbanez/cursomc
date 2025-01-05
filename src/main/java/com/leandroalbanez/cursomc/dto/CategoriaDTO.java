package com.leandroalbanez.cursomc.dto;

import com.leandroalbanez.cursomc.domain.Categoria;
import com.leandroalbanez.cursomc.repositories.CategoriaRepository;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private Integer id;
    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
