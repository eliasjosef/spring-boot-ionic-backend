package com.elias.regaliacrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elias.regaliacrud.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {


}
