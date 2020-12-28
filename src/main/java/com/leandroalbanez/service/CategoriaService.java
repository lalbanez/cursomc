package com.leandroalbanez.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandroalbanez.domain.Categoria;
import com.leandroalbanez.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		return repo.findById(id).orElse(null);
	}

}
