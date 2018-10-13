package com.proenca.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.proenca.domain.PagamentoComBoleto;

@Service
public class BoletoService {

	//Classe em produção deve ser substituida por webservice de geração de boleto
	public void preencherPagamentoComBoleto (PagamentoComBoleto pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
;	}
}
