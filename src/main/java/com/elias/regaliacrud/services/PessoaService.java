package com.elias.regaliacrud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elias.regaliacrud.domain.Pessoa;
import com.elias.regaliacrud.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;
	
	public Pessoa buscar(Integer id) {
		
		Pessoa obj = repo.getOne(id);
		
		return obj;
		
	}

}
