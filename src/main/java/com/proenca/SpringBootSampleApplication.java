package com.proenca;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.proenca.domain.Categoria;
import com.proenca.domain.Cidade;
import com.proenca.domain.Cliente;
import com.proenca.domain.Endereco;
import com.proenca.domain.Estado;
import com.proenca.domain.ItemPedido;
import com.proenca.domain.Pagamento;
import com.proenca.domain.PagamentoComBoleto;
import com.proenca.domain.PagamentoComCartao;
import com.proenca.domain.Pedido;
import com.proenca.domain.Produto;
import com.proenca.domain.enums.EstadoPagamento;
import com.proenca.domain.enums.TipoCliente;
import com.proenca.repositories.CategoriaRepository;
import com.proenca.repositories.CidadeRepository;
import com.proenca.repositories.ClienteRepository;
import com.proenca.repositories.EnderecoRepository;
import com.proenca.repositories.EstadoRepository;
import com.proenca.repositories.ItemPedidoRepository;
import com.proenca.repositories.PagamentoRepository;
import com.proenca.repositories.PedidoRepository;
import com.proenca.repositories.ProdutoRepository;

@SpringBootApplication
public class SpringBootSampleApplication implements CommandLineRunner{


	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSampleApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
	}	
	
}
