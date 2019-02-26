package com.elias.regaliacrud.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elias.regaliacrud.domain.Pessoa;

@RestController
@RequestMapping(value="/pessoas")
public class PessoaResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Pessoa> lista(){
		
		Pessoa p1 = new Pessoa(123,"Elias");
		Pessoa p2 = new Pessoa(321,"José");
		
		List<Pessoa> lista = new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		
		return lista;
		
	}

}
