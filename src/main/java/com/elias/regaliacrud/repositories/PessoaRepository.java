package com.elias.regaliacrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elias.regaliacrud.domain.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {


}
