package com.leandroalbanez.cursomc.repositories;

import com.leandroalbanez.cursomc.domain.Categoria;
import com.leandroalbanez.cursomc.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
