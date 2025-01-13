package com.leandroalbanez.cursomc.services;

import com.leandroalbanez.cursomc.domain.PagamentoComBoleto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

@Service
public class BoletoService {

    public void preencherPagamentoComBoleto (PagamentoComBoleto pagamentoComBoleto, Date instantePedido) {
       Calendar cal = Calendar.getInstance();
       cal.setTime(instantePedido);
       cal.add(Calendar.DAY_OF_YEAR, 7);
       pagamentoComBoleto.setDataVencimento(cal.getTime());

    }
}
