package com.leandroalbanez.cursomc.repositories;

import com.leandroalbanez.cursomc.domain.Pedido;
import com.leandroalbanez.cursomc.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
