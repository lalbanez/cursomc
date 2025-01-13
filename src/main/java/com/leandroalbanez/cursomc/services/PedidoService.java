package com.leandroalbanez.cursomc.services;

import com.leandroalbanez.cursomc.domain.ItemPedido;
import com.leandroalbanez.cursomc.domain.PagamentoComBoleto;
import com.leandroalbanez.cursomc.domain.PagamentoComCartao;
import com.leandroalbanez.cursomc.domain.Pedido;
import com.leandroalbanez.cursomc.domain.enums.EstadoPagamento;
import com.leandroalbanez.cursomc.repositories.ItemPedidoRepository;
import com.leandroalbanez.cursomc.repositories.PagamentoRepository;
import com.leandroalbanez.cursomc.repositories.PedidoRepository;
import com.leandroalbanez.cursomc.repositories.ProdutoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private BoletoService boletoService;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;


    public Pedido find(Integer id) {
        Optional<Pedido> pedido = repository.findById(id);
        return pedido.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id
                + " Tipo: " + Pedido.class.getName(), Pedido.class));
    }

    @Transactional
    public Pedido insert(Pedido pedido) {
        pedido.setId(null);
        pedido.setInstante(new Date());
        pedido.getPagamento().setEstadoPagamento(EstadoPagamento.PENDENTE);
        pedido.getPagamento().setPedido(pedido);
        if (pedido.getPagamento() instanceof PagamentoComBoleto) {
            PagamentoComBoleto comBoleto = (PagamentoComBoleto) pedido.getPagamento();
            boletoService.preencherPagamentoComBoleto(comBoleto, pedido.getInstante());
        }
        pedido = repository.save(pedido);
        pagamentoRepository.save(pedido.getPagamento());
        for (ItemPedido ip : pedido.getItens()) {
            ip.setDesconto(0.0);
            ip.setPreco(produtoRepository.findById(ip.getProduto().getId()).orElseThrow().getPreco());
            ip.setPedido(pedido);
        }
        itemPedidoRepository.saveAll(pedido.getItens());

        return pedido;
    }
}
