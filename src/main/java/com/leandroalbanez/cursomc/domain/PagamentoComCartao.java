package com.leandroalbanez.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.leandroalbanez.cursomc.domain.enums.EstadoPagamento;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento implements Serializable {
    private Integer numeroParcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Integer numeroParcelas) {
        super(id, estadoPagamento, pedido);
        this.numeroParcelas = numeroParcelas;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }
}
