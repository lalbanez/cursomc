package com.leandroalbanez.cursomc.services;

import com.leandroalbanez.cursomc.domain.Pedido;
import com.leandroalbanez.cursomc.repositories.PedidoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;

    public Pedido buscar(Integer id){
        Optional<Pedido> pedido = repository.findById(id);
        return pedido.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id
                + " Tipo: " + Pedido.class.getName(),Pedido.class));
    }
}
