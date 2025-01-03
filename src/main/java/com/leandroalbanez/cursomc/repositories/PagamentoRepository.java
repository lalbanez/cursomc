package com.leandroalbanez.cursomc.repositories;

import com.leandroalbanez.cursomc.domain.Pagamento;
import com.leandroalbanez.cursomc.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
