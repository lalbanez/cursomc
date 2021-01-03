package com.leandroalbanez.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandroalbanez.domain.Categoria;
import com.leandroalbanez.repositories.CategoriaRepository;
import com.leandroalbanez.services.execeptions.ObjectNotFoundExeption;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id)  {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundExeption("Objeto não encontrao! Id: " + id +", Tipo: " + Categoria.class.getName()));
	}

}
