package com.proenca;

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
import com.proenca.domain.Produto;
import com.proenca.domain.enums.TipoCliente;
import com.proenca.repositories.CategoriaRepository;
import com.proenca.repositories.CidadeRepository;
import com.proenca.repositories.ClienteRepository;
import com.proenca.repositories.EnderecoRepository;
import com.proenca.repositories.EstadoRepository;
import com.proenca.repositories.ProdutoRepository;

@SpringBootApplication
public class SpringBootSampleApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired 
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSampleApplication.class, args);
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 * Com proposito de testes rest, ao iniciar a aplicação, utilizando a interface commandLineRunner, 
	 * iremos instanciar objetos para popular o banco para testes rest. 
	 */
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto (null, "Computador", 2000.00);
		Produto p2 = new Produto (null, "Impressora", 800.00);
		Produto p3 = new Produto (null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().add(cat1);
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));	
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado (null, "Minas Gerais");
		Estado est2 = new Estado (null, "São Paulo");
		
		Cidade c1 = new Cidade (null, "Uberlandia", est2);
		Cidade c2 = new Cidade (null, "Sao Paulo", est2);
		Cidade c3 = new Cidade (null, "Campinas", est1);
		
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		est1.getCidades().add(c1);
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria", "maria@gmail.com", "333.333.333-33", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363342", "85646464"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "00000-000", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777-465", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
	}	
	
}
