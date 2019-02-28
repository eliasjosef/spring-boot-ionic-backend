package com.elias.regaliacrud.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elias.regaliacrud.domain.Pessoa;
import com.elias.regaliacrud.repositories.PessoaRepository;
import com.elias.regaliacrud.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;
	
	public Pessoa buscar(Integer id) {
		
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Pessoa.class.getName()));
		
		
	}

}
