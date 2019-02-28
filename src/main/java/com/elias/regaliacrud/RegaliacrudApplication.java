package com.elias.regaliacrud;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.elias.regaliacrud.domain.Cidade;
import com.elias.regaliacrud.domain.Cliente;
import com.elias.regaliacrud.domain.Estado;
import com.elias.regaliacrud.domain.Pessoa;
import com.elias.regaliacrud.repositories.CidadeRepository;
import com.elias.regaliacrud.repositories.ClienteRepository;
import com.elias.regaliacrud.repositories.EstadoRepository;
import com.elias.regaliacrud.repositories.PessoaRepository;

@SpringBootApplication
public class RegaliacrudApplication implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository; 
	
	
	public static void main(String[] args) {
		SpringApplication.run(RegaliacrudApplication.class, args);
			
	}

	@Override
	public void run(String... args) throws Exception {
		Pessoa p1 = new Pessoa(null, "Maria");
		Pessoa p2 = new Pessoa(null, "Lucia");
		
		Cliente c1 = new Cliente(null, "Severina", "severina@sevrina.com.br");
		Cliente c2 = new Cliente(null, "Monica", "monica@monica.com.br");
		Cliente c3 = new Cliente(null, "Gilberto", "gilberto@gilberto.com.br");
		
		Estado est1 = new Estado(null, "Pernambuco");
		Estado est2 = new Estado(null, "Alagoas");
		
		Cidade cd1 = new Cidade(null, "Recife", est1);
		Cidade cd2 = new Cidade(null, "Olinda", est1);
		Cidade cd3 = new Cidade(null, "Maceió", est2);
		
		
		p1.getClientes().addAll(Arrays.asList(c1, c2, c3));
		p2.getClientes().addAll(Arrays.asList(c2));
		
		c1.getPessoas().addAll(Arrays.asList(p1));
		c2.getPessoas().addAll(Arrays.asList(p1, p2));
		c3.getPessoas().addAll(Arrays.asList(p1));
		
		est1.getCidades().addAll(Arrays.asList(cd1, cd2));
		est2.getCidades().addAll(Arrays.asList(cd3));
		
		
		pessoaRepository.saveAll(Arrays.asList(p1, p2));
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cd1, cd2, cd3));
	}

}
