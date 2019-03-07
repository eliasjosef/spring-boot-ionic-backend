package com.elias.regaliacrud;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.elias.regaliacrud.domain.Categoria;
import com.elias.regaliacrud.domain.Cidade;
import com.elias.regaliacrud.domain.Cliente;
import com.elias.regaliacrud.domain.Endereco;
import com.elias.regaliacrud.domain.Estado;
import com.elias.regaliacrud.domain.Produto;
import com.elias.regaliacrud.domain.enums.TipoCliente;
import com.elias.regaliacrud.repositories.CategoriaRepository;
import com.elias.regaliacrud.repositories.CidadeRepository;
import com.elias.regaliacrud.repositories.ClienteRepository;
import com.elias.regaliacrud.repositories.EnderecoRepository;
import com.elias.regaliacrud.repositories.EstadoRepository;
import com.elias.regaliacrud.repositories.ProdutoRepository;

@SpringBootApplication
public class RegaliacrudApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository; 
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(RegaliacrudApplication.class, args);
			
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria p1 = new Categoria(null, "Informática");
		Categoria p2 = new Categoria(null, "Escritório");
		
		Produto c1 = new Produto(null, "Notebook", "Dell 14': Intel Core i5");
		Produto c2 = new Produto(null, "Impressora", "Epson L330");
		Produto c3 = new Produto(null, "Mouse", "Dell M660");
		
		Estado est1 = new Estado(null, "Pernambuco");
		Estado est2 = new Estado(null, "Alagoas");
		
		Cidade cd1 = new Cidade(null, "Recife", est1);
		Cidade cd2 = new Cidade(null, "Olinda", est1);
		Cidade cd3 = new Cidade(null, "Maceió", est2);
		
		
		p1.getProdutos().addAll(Arrays.asList(c1, c2, c3));
		p2.getProdutos().addAll(Arrays.asList(c2));
		
		c1.getCategorias().addAll(Arrays.asList(p1));
		c2.getCategorias().addAll(Arrays.asList(p1, p2));
		c3.getCategorias().addAll(Arrays.asList(p1));
		
		est1.getCidades().addAll(Arrays.asList(cd1, cd2));
		est2.getCidades().addAll(Arrays.asList(cd3));
		
		categoriaRepository.saveAll(Arrays.asList(p1, p2));
		produtoRepository.saveAll(Arrays.asList(c1, c2, c3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cd1, cd2, cd3));
		
		Cliente cl1 = new Cliente(null, "Elias Santos", "elias@elias.com", "123.345.567-78", TipoCliente.PESSOAJURIDICA);
		
		cl1.getTelefones().addAll(Arrays.asList("8888-8888", "9999-9999"));
		
		clienteRepository.saveAll(Arrays.asList(cl1));
		
		Endereco ed1 = new Endereco(null, "Rua Icó", "74", "Casa", "Pina", "51011-090", cd1, cl1);
		
		enderecoRepository.saveAll(Arrays.asList(ed1));
		
	}

}
