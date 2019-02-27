package com.elias.regaliacrud;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.elias.regaliacrud.domain.Cliente;
import com.elias.regaliacrud.domain.Pessoa;
import com.elias.regaliacrud.repositories.ClienteRepository;
import com.elias.regaliacrud.repositories.PessoaRepository;

@SpringBootApplication
public class RegaliacrudApplication implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
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
		
		p1.getClientes().addAll(Arrays.asList(c1, c2, c3));
		p2.getClientes().addAll(Arrays.asList(c2));
		
		c1.getPessoas().addAll(Arrays.asList(p1));
		c2.getPessoas().addAll(Arrays.asList(p1, p2));
		c3.getPessoas().addAll(Arrays.asList(p1));
		
		pessoaRepository.saveAll(Arrays.asList(p1, p2));
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3));
	}

}
