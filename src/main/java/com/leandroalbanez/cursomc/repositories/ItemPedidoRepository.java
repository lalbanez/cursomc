package com.leandroalbanez.cursomc.repositories;

import com.leandroalbanez.cursomc.domain.Categoria;
import com.leandroalbanez.cursomc.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

}
