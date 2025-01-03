package com.leandroalbanez.cursomc.repositories;

import com.leandroalbanez.cursomc.domain.Cidade;
import com.leandroalbanez.cursomc.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
